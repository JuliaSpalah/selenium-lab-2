package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[text()='Brands']")
    private WebElement brandsLinkLocator;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountLocator;

    @FindBy(xpath = "//a[@class='dropdown-item' and text()='Login']")
    private WebElement loginLocator;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public BrandsPage clickBrandsLink() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", brandsLinkLocator);
        return new BrandsPage();
    }

    public MainPage clickOnMyAccount() {
        myAccountLocator.click();
        return this;
    }

    public LoginPage clickOnLogin() {
        loginLocator.click();
        return new LoginPage();
    }


}

