import org.example.IPhonePage;
import org.example.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestIPhoneCurrencyAndPrices extends BaseTest {

    @Test
    public void testCheckCurrencyAndPrices() {
        IPhonePage iPhonePage = new IPhonePage();
        MainPage mainPage = new MainPage();
        String actualResultCurrencySign = mainPage.getCurrencySign();

        // можна виносити expectedResult окремою змінною, якщо треба використати змінну кілька раз
        // в одному тесті. В данному прикладі це не потрібно. Просто приклад.
        double expectedResult = 123.20;

        assertEquals(actualResultCurrencySign, "$", "The currency sign should be $");


        double actualResultIPhonePriceDollars = mainPage
                .clickOnIPhone()
                .getIPhonePriceDollars();

        assertEquals(actualResultIPhonePriceDollars, expectedResult, "The price is not 123.20");


        double actualResultIPhonePriceEUR = iPhonePage
                .clickOnCurrencySign()
                .clickOnEUR()
                .getIPhonePriceEuro();

        assertEquals(actualResultIPhonePriceEUR, 113.38, "The price is not 113.38");

        double actualResultIPhonePriceGBP = iPhonePage
                .clickOnCurrencySign()
                .clickOnGBP()
                .getIPhonePricePoundsSterling();

        assertEquals(actualResultIPhonePriceGBP, 97.31, "The price is not 97.31");


    }


}
