package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[text()='Brands']")
    private WebElement brandsLinkLocator;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountLocator;

    @FindBy(xpath = "//a[@class='dropdown-item' and text()='Login']")
    private WebElement loginLocator;

    @FindBy(xpath = "//div[@id='narbar-menu']//a[text()='Desktops']")
    private WebElement desktopsLocator;

    @FindBy(xpath = "//div[@id='narbar-menu']//a[text()='Show All Desktops']")
    private WebElement showAllDesktops;

    @FindBy(xpath = "//a[span[text()='Currency']]//strong")
    private WebElement currencySign;

    @FindBy(xpath = "//div[@class='product-thumb']//a[text()='iPhone']")
    private WebElement iPhoneOnMainPage;

    @FindBy(xpath = "//a[@class='nav-link' and text()='Cameras']")
    private WebElement cameras;

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

    public MainPage hoverOverDesktops() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(desktopsLocator).perform();
        return this;
    }

    public MainPage clickOnDesktops() {
        desktopsLocator.click();
        return this;
    }

    public AllDesktopsPage clickOnShowAllDesktops() {
        AllDesktopsPage allDesktopsPage = new AllDesktopsPage();
        showAllDesktops.click();
        return new AllDesktopsPage();
    }

    public String getCurrencySign() {
        return currencySign.getText();
    }

    public IPhonePage clickOnIPhone(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", iPhoneOnMainPage);
        return new IPhonePage();
    }

    public CamerasPage clickOnCameras(){
        cameras.click();
        return new CamerasPage();
    }


}

