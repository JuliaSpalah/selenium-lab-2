package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;

public class IPhonePage extends BasePage {

    @FindBy(xpath = "//h2/span[@class='price-new']")
    private WebElement iPhonePrice;

    @FindBy(xpath = "//a[span[text()='Currency']]//strong")
    private WebElement currencySign;

    @FindBy(xpath = "//a[text()='€ Euro']")
    private WebElement euroCurrency;

    @FindBy(xpath = "//a[text()='£ Pound Sterling']")
    private WebElement poundSterlingCurrency;

    public IPhonePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public double getIPhonePriceDollars() {
        String priceText = iPhonePrice.getText();
        return StringUtils.extractPriceValue(priceText);
    }

    public IPhonePage clickOnCurrencySign() {
        currencySign.click();
        return this;
    }

    public IPhonePage clickOnEUR() {
        euroCurrency.click();
        return this;
    }

    public double getIPhonePriceEuro() {
        String priceText = iPhonePrice.getText();
        return StringUtils.extractPriceValue(priceText);
    }

    public IPhonePage clickOnGBP() {
        poundSterlingCurrency.click();
        return this;
    }

    public double getIPhonePricePoundsSterling() {
        String priceText = iPhonePrice.getText();
        return StringUtils.extractPriceValue(priceText);
    }

}
