package com.homeaharaa.pages;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SpiceMix extends TestBase{

    static WebDriver driver;

    SeleniumUtils seleutils = new SeleniumUtils();

    public SpiceMix(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@id='product_listing']//li//child::h4/a")
    @CacheLookup
    public List<WebElement> productNames;

    @FindBy(xpath = "//div[contains(text(),'Total price: ')]//span[@class='woocommerce-Price-amount amount']")
    @CacheLookup
    public WebElement price;
    @FindBy(xpath = "(//div[@class='wooco_component_name']/following-sibling::div//a[@class='dd-selected'])[1]")
    @CacheLookup
    public WebElement selectWeightDropDown;


    @FindBy(xpath = "//div[@class='quantity buttons_added']///input[@type='number']")
    @CacheLookup
    public WebElement quantity;
    @FindBy(xpath = "//ul[@class='page-numbers']/li[last()-1]")
    @CacheLookup
    public WebElement totalPages;
    public String minPrice = "(//a[text()='PRODUCT']//ancestor::div[@class='item-content products-content']//child::span[@class='woocommerce-Price-amount amount'])[1]";
    public String maxPrice = "(//a[text()='PRODUCT']//ancestor::div[@class='item-content products-content']//child::span[@class='woocommerce-Price-amount amount'])[2]";
    public String weight = "//span[@class='dd-pointer dd-pointer-down dd-pointer-up']/parent::div/following-sibling::ul/li/a/label[contains(.,'- WEIGHT')]";


    public void selectProduct(String strName) {
        WebElement z = null;
        Integer g = Integer.parseInt(totalPages.getText());
        for (int i = 1; i < g + 1; i++) {
            try {
                z = productNames.stream().filter(x -> x.getText().equalsIgnoreCase(strName)).findFirst().get();
                break;
            } catch (StaleElementReferenceException e) {
                PageFactory.initElements(driver, this);
                i -= 1;
            } catch (NoSuchElementException e) {
                driver.findElement(By.xpath("//li/*[text()='" + i + "']")).click();
            }catch (NullPointerException e){
                System.out.println("Product is missing : "+strName);

            }
        }

        z.click();
    }

    public String getMinPrice(String strName) {
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
        String gram = grams.replaceAll(" Grams| gram|Gram|grams|Grams| grams", "g");
        selectWeightDropDown.click();
        driver.findElement(By.xpath(weight.replace("WEIGHT", gram))).click();
    }

    public void selectQuantity(Integer grams) {
        quantity.click();
        quantity.sendKeys(Keys.DELETE);
        quantity.sendKeys(grams.toString());

    }

    public ArrayList<String> getProductsList() {
        return (ArrayList<String>) productNames.stream().map(x -> x.getText()).collect(Collectors.toList());
    }

    @DataProvider(name = "Product-Rates")
    public static Object[][] dpMethod() {
        String query = "Select * from Spices";
        ArrayList<HashMap<String, String>> ar = TestBase.readExcelUsingFillo("SellingPRICEOFEACHPRODUCT Full.xlsx", query);
        return new Object[][]{
                {"Spices", ar}
        };
    }

    public String getPrice() {
        String val=null;
        try {
            val= price.getText();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
        }
        return price.getText();
    }

}
