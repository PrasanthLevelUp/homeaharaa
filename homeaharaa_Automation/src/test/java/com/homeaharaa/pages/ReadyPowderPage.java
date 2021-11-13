package com.homeaharaa.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.CommonUtils;
import com.homeaharaa.Utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class ReadyPowderPage extends TestBase {

	static WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public ReadyPowderPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);

	}


	@FindBy(xpath = "//li/span[text()='Readymade Powders']")
	public WebElement txtCarosel;
	@FindBy(xpath = "//h1[text()='Readymade Powders']")
	public WebElement txtPageHeader;
	@FindBy(xpath = "//*[@class='current']/a")
	public WebElement lnkProductCount;
	
	
	@FindBys(@FindBy(xpath = "//div[@id='contents']//section//div[contains(@id,'latest_sw_woo_tab_slider')]"))
	public List<WebElement> allsections;
	//object for Product Names
	@FindBy(xpath = "//*[contains(@class,'item-content')]/h4/a")
	public List<WebElement> allProductName;
	//object for Add to cart
	@FindBy(xpath = "//a[@title='Add To Cart']")
	public List<WebElement> allAddToCart;
	//Object for pagination
	@FindBy(xpath = "//*[contains(@class,'page-numbers')]/li")
	public List<WebElement> pagination;

	@FindBys(@FindBy(xpath = "//ul[@class='page-numbers']//li"))
	public List<WebElement> pages;
	@FindBys(@FindBy(xpath = "//ul[@id='product_listing']//h4//a"))
	public List<WebElement> itemheading;
	@FindBy(xpath = "//div[@class='content_product_detail']//h1")
	public WebElement productname;
	@FindBys(@FindBy(xpath = "//div[@class='sw-custom-variation']//span"))
	public List<WebElement> kgvariation;
	@FindBy(xpath = "//div[@class='single-price']//span[@class='variable-price']//span[@class='woocommerce-Price-amount amount']")
	public WebElement productprice;
	@FindBys(@FindBy(xpath = "//ul[@class='breadcrumb']//li//a"))
	public List<WebElement> toppages;

	public void gotoeachitem() throws InterruptedException {
		String itemname = null;

		// String lastpagenumber =
		// pages.get(pages.size()-2).findElement(By.tagName("a")).getText();

		for (int i = 0; i < pages.size(); i++) {
			Thread.sleep(3000);
			for (int j = 0; j < itemheading.size(); j++) {
				itemheading.get(j).click();
				Thread.sleep(2000);
				itemname = productname.getText();
				HashMap<Object, Object> itemdetails = CommonUtils.readjsondata(
						System.getProperty("user.dir") + "/src/main/resources/itempricedetailsjsonfiles/SPICES.json",
						"Name of the Product", itemname);
				if (!itemdetails.isEmpty()) {
					kgvariation.get(0).click();
					Thread.sleep(2000);
					double expectedval250 = CommonUtils.convertdo(itemdetails.get("250 gm").toString());
					double actualval250 = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval250, actualval250);
					kgvariation.get(1).click();
					double expectedval500 = CommonUtils.convertdo(itemdetails.get("500 gm").toString());
					double actualval500 = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval500, actualval500);
					kgvariation.get(2).click();
					double expectedval1kg = CommonUtils.convertdo(itemdetails.get("1 KG").toString());
					double actualval1kg = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval1kg, actualval1kg);
				} else {
					System.out.println("Item Not Available " + itemname);
				}
				driver.navigate().back();
				// toppages.get(toppages.size() - 1).click();
				Thread.sleep(2000);
			}
			pages.get(pages.size() - 1).findElement(By.tagName("a")).click();
		}

	}

	
}
