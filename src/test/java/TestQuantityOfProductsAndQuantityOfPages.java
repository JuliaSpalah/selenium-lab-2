import org.assertj.core.api.SoftAssertions;
import org.example.AllDesktopsPage;
import org.example.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestQuantityOfProductsAndQuantityOfPages extends BaseTest {

    @Test
    public void testCheckShow() {
        AllDesktopsPage allDesktopsPage = new AllDesktopsPage();
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();

        String actualResultShow = mainPage
                .hoverOverDesktops()
                .clickOnDesktops()
                .clickOnShowAllDesktops()
                .checkShowSelectedValue();
        softAssertions.assertThat(actualResultShow).as("Can`t check a Show selected value").isEqualTo("10");
        assertEquals(actualResultShow, "10", "Can`t check a Show selected value");

        String actualResultSortBy = allDesktopsPage
                .checkSortBySelectedValue();
        softAssertions.assertThat(actualResultSortBy).as("Can`t check a Sort By selected value").isEqualTo("Default");
        assertEquals(actualResultSortBy, "Default", "Can`t check a Sort By selected value");

        int actualResultQuantityOfProducts = allDesktopsPage
                .getQuantityOfProducts();
        assertEquals(actualResultQuantityOfProducts, 10, "Products thumbnails count should be equals 10");

        int actualResultQuantityOfProducts2 = allDesktopsPage
               // .clickOnShowDropdown()
                .select25FromShowDropdown("25")
                .getQuantityOfProducts2();
        assertEquals(actualResultQuantityOfProducts2, 12, "Products thumbnails count should be equals 12");

          String actualResultQuantityOfPages = allDesktopsPage
                  .scrollToPagesQuantity()
                  .getPagesQuantity();
        assertEquals(actualResultQuantityOfPages, "Showing 1 to 12 of 12 (1 Pages)","The pages quantity should be Showing 1 to 12 of 12 (1 Pages)");



    }
    }





