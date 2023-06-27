import org.example.CamerasPage;
import org.example.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCamerasQuantityAndPrices extends BaseTest {
    @Test
    public void testCamerasExistenceAndPrices() {
        MainPage mainPage = new MainPage();
        CamerasPage camerasPage = new CamerasPage();

        int actualResultCamerasQuantity = mainPage
                .clickOnCameras()
                .getCamerasQuantityOnPage();

        assertEquals(actualResultCamerasQuantity, 2, "Shown cameras is not 2");

        double actualResultOldPriceCanon = camerasPage
                .getOldPriceFirstCamera();
        assertEquals(actualResultOldPriceCanon, 122.00, "The old price is not 122.00");

        double actualResultNewPriceCanon = camerasPage
                .getNewPriceFirstCamera();
        assertEquals(actualResultNewPriceCanon, 98.00, "The new price is not 98.00");

        double actualResultTaxPriceNikon = camerasPage
                .getTaxPriceSecondCamera();
        assertEquals(actualResultTaxPriceNikon, 80.00, "The Ex Tax price is not 80.00");

    }


}
