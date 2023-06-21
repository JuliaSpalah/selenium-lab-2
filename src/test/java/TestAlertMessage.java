import org.example.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestAlertMessage extends BaseTest {
    @Test
    public void testAlertMessage() {
        MainPage mainPage = new MainPage();
        String alertMessage = mainPage
                .clickOnMyAccount()
                .clickOnLogin()
                .clickOnForgottenPassword()
                .setEmailToEmailField("john.snow@mail.com")
                .clickOnContinueButton()
                .getAlertMessageAfterSecond();
        assertEquals(alertMessage,
                "Warning: The E-Mail Address was not found in our records!",
                "The alert message should be Warning: The E-Mail Address was not found in our records! ");


    }
}
