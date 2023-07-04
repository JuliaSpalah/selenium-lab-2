package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AllDesktopsPage extends BasePage {
    @FindBy(xpath = "//div[label[text()='Show']]//select[@id='input-limit']")
    private WebElement showSelectedValue;

    @FindBy(xpath = "//div[label[text()='Sort By']]//select[@id='input-sort']")
    private WebElement sortBySelectedValue;

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> productThumbs;

    // @FindBy(xpath = "//div[label[text()='Show']]//select")
    //private WebElement showDropDown;

    @FindBy(xpath = "//select[@id='input-limit']")
    private WebElement showDropDown;

    @FindBy(xpath = "//div[label[text()='Show']]//option[text()='25']")
    private WebElement showDropDown25;

    @FindBy(xpath = "//*[@id='content']//div[@class='col-sm-6 text-end']")
    private WebElement pagesQuantity;

    @FindBy(xpath = "//div[label[text()='Sort By']]//select")
    private WebElement sortByDropDown;

    @FindBy(xpath = "//div[label[text()='Sort By']]//option[text()='Name (A - Z)']")
    private WebElement orderNameAToZ;

    @FindBy(xpath = "//div[@class='product-thumb']//div[@class='description']//a")
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[label[text()='Sort By']]//option[text()='Price (Low > High)']")
    private WebElement orderPriceLowToHigh;

    @FindBy(xpath = "//div[@class='product-thumb']//div[@class='description']//span[@class='price-new']")
    private List<WebElement> productPrices;

    public AllDesktopsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String checkShowSelectedValue() {
        Select select = new Select(showSelectedValue);
        return select.getFirstSelectedOption().getText();
    }

    public String checkSortBySelectedValue() {
        Select select = new Select(sortBySelectedValue);
        return select.getFirstSelectedOption().getText();
    }

    public int getQuantityOfProducts() {
        return productThumbs.size();
    }

  //  public AllDesktopsPage clickOnShowDropdown() {
  //      showDropDown.click();
   //     return this;
  //  }

//    public AllDesktopsPage clickOnShowDropdown25() {
//        showDropDown25.click();
//        return this;
//    }

    public AllDesktopsPage select25FromShowDropdown(String value) {
        Select select = new Select(showDropDown);
        select.selectByVisibleText(value);
        return this;
    }

    public int getQuantityOfProducts2() {
        return productThumbs.size();
    }

    public AllDesktopsPage scrollToPagesQuantity() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", pagesQuantity);
        return new AllDesktopsPage();
    }

    public String getPagesQuantity() {
        String pages = pagesQuantity.getText();
        return pages;
    }

    public AllDesktopsPage clickOnSortByDropdown() {
        sortByDropDown.click();
        return this;
    }

    public AllDesktopsPage clickOnOrderNameAToZ() {
        orderNameAToZ.click();
        return this;
    }

    public List<String> getProductNames() {
        return productNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public AllDesktopsPage clickOnPriceLowToHigh() {
        orderPriceLowToHigh.click();
        return this;
    }

    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .collect(Collectors.toList());
    }

}
