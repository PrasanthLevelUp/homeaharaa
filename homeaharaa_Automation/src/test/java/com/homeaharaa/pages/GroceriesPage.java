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

public class GroceriesPage extends TestBase {

	static WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public GroceriesPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//div[@class='elementor-widget-container']//span[contains(text(),'Login')]")
	@CacheLookup
	public WebElement topLogin;
	@FindBy(xpath = "//div[@id='sw_woo_search_1']//input[@class='autosearch-input']")
	public WebElement searchbox;
	@FindBy(xpath = "//div[@id='sw_woo_search_1']//button")
	public WebElement searchbtn;
	@FindBy(xpath = "//h5[contains(text(),'My Account')]")
	public WebElement myaccount;
	@FindBy(xpath = "//ul[@id='menu-my-account']//span[contains(text(),'Cart')]")
	public WebElement myaccountcart;
	@FindBy(xpath = "//ul[@id='menu-my-account']//span[contains(text(),'Wishlist')]")
	public WebElement myaccountwishlist;
	@FindBy(xpath = "//ul[@id='menu-my-account']//span[contains(text(),'Checkout')]")
	public WebElement myaccountcheckout;
	@FindBy(xpath = "//ul[@id='menu-my-account']//span[contains(text(),'My Account')]")
	public WebElement myaccountMyaccount;
	@FindBy(xpath = "//div[@class='wmc-currency-wrapper']")
	public WebElement curreny;
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	public WebElement homelink;
	@FindBy(xpath = "//span[contains(text(),'Sweets & Snacks')]")
	public WebElement sweetandsnack;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//span[contains(text(),'Sweets')]")
	public WebElement sweetdropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//span[contains(text(),'Snacks')]")
	public WebElement snackdropdown;
	@FindBy(xpath = "//li[contains(@class,'menu-spices')]/a/span/span[contains(text(),'Spices')]")
	public WebElement spicesdropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//span[contains(text(),'Groceries / Whole Spices')]")
	public WebElement groceriesdropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//span[contains(text(),'Custom Powders')]")
	public WebElement custompowderdropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//span[contains(text(),'Readymade Powders')]")
	public WebElement readymadepowderdropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//span[contains(text(),'Papad')]")
	public WebElement papaddropdown;
	@FindBy(xpath = "//span[contains(text(),'Utensils')]")
	public WebElement utensilsdropdown;
	@FindBy(xpath = "//div[contains(@class,'elementor-column')]//a[@class='cart-contents']")
	public WebElement carticon;
	@FindBy(xpath = "//div[contains(@class,'elementor-widget-wp-widget-sw_top')]//div[@class='cart-right']//span[contains(@class,'amount')]")
	public WebElement totalpriceincart;
	@FindBy(xpath = "//div[contains(@class,'elementor-widget-wp-widget-sw_top')]//div[@class='cart-right']//span[contains(@class,'minicart-number')]")
	public WebElement totalitemincart;
	
	//div[@id='contents']//section//div[@id='latest_sw_woo_tab_slider_1']//div[ @aria-hidden='false']//h4//a

	@FindBys(@FindBy(xpath = "//div[@id='contents']//section//div[contains(@id,'latest_sw_woo_tab_slider')]"))
	public List<WebElement> allsections;
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
						System.getProperty("user.dir") + "/src/main/resources/itempricedetailsjsonfiles/Groceries.json",
						"NAME OF THE ITEMS", itemname);
				if (!itemdetails.isEmpty()) {
					kgvariation.get(0).click();
					Thread.sleep(2000);
					double expectedval25 = CommonUtils.convertdo(itemdetails.get("25 Grams").toString());
					double actualval25 = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval25, actualval25);
					kgvariation.get(1).click();
					double expectedval50 = CommonUtils.convertdo(itemdetails.get("50 Grams").toString());
					double actualval50 = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval50, actualval50);
					kgvariation.get(2).click();
					double expectedval100 = CommonUtils.convertdo(itemdetails.get("100 Grams").toString());
					double actualval100 = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval100, actualval100);
					kgvariation.get(3).click();
					double expectedval250 = CommonUtils.convertdo(itemdetails.get("250 Grams").toString());
					double actualval250 = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval250, actualval250);
					kgvariation.get(4).click();
					double expectedval500 = CommonUtils.convertdo(itemdetails.get("500 Grams").toString());
					double actualval500 = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedval500, actualval500);
					kgvariation.get(5).click();
					double expectedval1kg = CommonUtils.convertdo(itemdetails.get("1 kg").toString());
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
