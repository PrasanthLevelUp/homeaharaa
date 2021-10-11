package com.homeaharaa.pages;

import java.util.List;
import java.util.Optional;

import com.google.common.io.ByteStreams;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class GroceriesPage extends TestBase {

    static WebDriver driver;

    SeleniumUtils seleutils = new SeleniumUtils();

    public GroceriesPage(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@id='product_listing']//li//child::h4")
    @CacheLookup
    public List<WebElement> productNames;

    @FindBy(xpath = "//span[@class='variable-price']//span[@class='woocommerce-Price-amount amount']")
    @CacheLookup
    public WebElement price;

    @FindBy(xpath = "//input[@type='number']")
    @CacheLookup
    public WebElement quantity;
    public String minPrice = "(//a[text()='PRODUCT']//ancestor::div[@class='item-content products-content']//child::span[@class='woocommerce-Price-amount amount'])[1]";
    public String maxPrice = "(//a[text()='PRODUCT']//ancestor::div[@class='item-content products-content']//child::span[@class='woocommerce-Price-amount amount'])[2]";
    public String weight = "//*[@title='WEIGHT']//span";


    public void selectProduct(String strName) {
        WebElement z = productNames.stream().filter(x -> x.getText().equalsIgnoreCase(strName.toUpperCase())).findFirst().get();
        z.click();
    }

    public String  getMinPrice(String strName) {
       return driver.findElement(By.xpath(minPrice.replace("PRODUCT", strName.toUpperCase()))).getText();
    }

    public String getMaxPrice(String strName) {
       return driver.findElement(By.xpath(maxPrice.replace("PRODUCT", strName.toUpperCase()))).getText();
    }

    public String getPriceBasedWeightAndQuantity(String strName, String strWeight, Integer quantity) {
        selectProduct(strName);
        selectWeight(strWeight);
        selectQuantity(quantity);
       return price.getText();
    }

    public void selectWeight(String grams) {
        driver.findElement(By.xpath(weight.replace("WEIGHT", grams))).click();
    }

    public void selectQuantity(Integer grams) {
        quantity.click();
        quantity.sendKeys(Keys.DELETE);
        quantity.sendKeys(grams.toString());

    }


}
