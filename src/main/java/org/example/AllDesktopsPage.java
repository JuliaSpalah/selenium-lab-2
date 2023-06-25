package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AllDesktopsPage extends BasePage {
    @FindBy(xpath = "//div[label[text()='Show']]//select[@id='input-limit']")
    private WebElement showSelectedValue;

    @FindBy(xpath = "//div[label[text()='Sort By']]//select[@id='input-sort']")
    private WebElement sortBySelectedValue;

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> productThumbs;

    @FindBy(xpath = "//div[label[text()='Show']]//select")
    private WebElement showDropDown;

    @FindBy(xpath = "//div[label[text()='Show']]//option[text()='25']")
    private WebElement showDropDown25;

    @FindBy(xpath = "//*[@id='content']//div[@class='col-sm-6 text-end']")
    private WebElement pagesQuantity;

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

    public AllDesktopsPage clickOnShowDropdown(){
        showDropDown.click();
        return this;
    }

    public AllDesktopsPage clickOnShowDropdown25(){
        showDropDown25.click();
        return this;
    }

    public int getQuantityOfProducts2(){
        return productThumbs.size();
    }

    public AllDesktopsPage scrollToPagesQuantity() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);",pagesQuantity);
        return new AllDesktopsPage();
    }
    public String getPagesQuantity(){
        String pages = pagesQuantity.getText();
        return pages;
    }
}
