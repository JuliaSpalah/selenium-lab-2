package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;

import java.util.List;

public class CamerasPage extends BasePage {
    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> camerasThumbnails;

    @FindBy(xpath = "//span[@class='price-old']")
    private WebElement oldPriceFirstCamera;

    @FindBy(xpath = "//div[h4/a[text()='Canon EOS 5D'] and @class='description']//span[@class='price-new']")
    private WebElement newPriceFirstCamera;

    @FindBy(xpath = "//div[h4/a[text()='Nikon D300'] and @class='description']//span[@class='price-tax']")
    private WebElement taxPriceSecondCamera;

    public CamerasPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public int getCamerasQuantityOnPage() {
        return camerasThumbnails.size();
    }

    public double getOldPriceFirstCamera() {
        String priceText = oldPriceFirstCamera.getText();
        return StringUtils.extractPriceValue(priceText);
    }

    public double getNewPriceFirstCamera() {
        String priceText = newPriceFirstCamera.getText();
        return StringUtils.extractPriceValue(priceText);

    }

    public double getTaxPriceSecondCamera(){
        String priceText = taxPriceSecondCamera.getText();
        return StringUtils.extractPriceValue(priceText);
    }
}