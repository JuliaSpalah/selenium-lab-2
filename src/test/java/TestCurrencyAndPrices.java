import org.example.IPhonePage;
import org.example.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCurrencyAndPrices extends BaseTest {

    @Test
    public void testCheckCurrencyAndPrices() {
        IPhonePage iPhonePage = new IPhonePage();
        MainPage mainPage = new MainPage();
        String actualResultCurrencySign = mainPage.getCurrencySign();

        assertEquals(actualResultCurrencySign, "$", "The currency sign should be $");


        double actualResultIPhonePriceDollars = mainPage
                .clickOnIPhone()
                .getIPhonePriceDollars();

        assertEquals(actualResultIPhonePriceDollars, 123.20, "The price is not 123.20");


        double actualResultIPhonePriceEUR = iPhonePage
                .clickOnCurrencySign()
                .clickOnEUR()
                .getIPhonePriceEuro();

        assertEquals(actualResultIPhonePriceEUR, 112.65, "The price is not 106.04");


        double actualResultIPhonePriceGBP = iPhonePage
                .clickOnCurrencySign()
                .clickOnGBP()
                .getIPhonePricePoundsSterling();

        assertEquals(actualResultIPhonePriceGBP, 100.54, "The price is not 95.32");


    }


}
