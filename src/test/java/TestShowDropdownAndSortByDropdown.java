import org.example.AllDesktopsPage;
import org.example.MainPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestShowDropdownAndSortByDropdown extends BaseTest {

    @Test
    public void testSortBy(){
        AllDesktopsPage allDesktopsPage = new AllDesktopsPage();
        MainPage mainPage = new MainPage();

        List<String> actualResultSortBy = mainPage
                .hoverOverDesktops()
                .clickOnDesktops()
                .clickOnShowAllDesktops()
                .clickOnSortByDropdown()
                .clickOnOrderNameAToZ()
                .getProductNames();

        List<String> sortedProductNames = new ArrayList<>(actualResultSortBy);
        sortedProductNames.sort(String::compareToIgnoreCase);
        assertEquals(actualResultSortBy, sortedProductNames, "Product names are not sorted in alphabetic order");

        List<Double> actualResultProductPricesOrder = allDesktopsPage
                .clickOnPriceLowToHigh()
                .getProductPrices();

        List<Double> sortedProductPrices = new ArrayList<>(actualResultProductPricesOrder);
        Collections.sort(sortedProductPrices);
        assertEquals(actualResultProductPricesOrder, sortedProductPrices, "Product prices are not sorted from low to high");

    }

}
