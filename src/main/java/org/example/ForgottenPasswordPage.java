package org.example;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage extends BasePage {

    @FindBy(xpath = "//*[@id='input-email']")
    private WebElement emailInputLocator;
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButtonForgottenPasswordLocator;

    @FindBy(xpath = "//div[@id='alert']//div")
    private WebElement alertMessage;

    public ForgottenPasswordPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ForgottenPasswordPage setEmailToEmailField(String email) {
        emailInputLocator.sendKeys(email);
        return this;
    }

    public ForgottenPasswordPage clickOnContinueButton() {
        continueButtonForgottenPasswordLocator.click();
        return this;
    }

    public String getAlertMessageAfterSecond() {
        waitSeconds(1);
        return alertMessage.getText();
    }
}
