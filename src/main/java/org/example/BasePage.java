package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class BasePage {


    //protected WebDriver variable (only classes in same folder (pages) will get driver)
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

//    /public void clickBrandsLink() {
//        WebElement element = find(brandsLinkLocator);
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click()", element);
//
//    }

    @FindBy(xpath = "//div[@id='alert']//div")
    private WebElement alertMessage;

    public void waitSeconds(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("Can`t wait for " + seconds + " seconds");
        }
    }

    public String getAlertMessageAfterSecond() {
        waitSeconds(1);
        return alertMessage.getText();
    }


}

