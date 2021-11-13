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

public class PapadPage extends TestBase {

	static WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public PapadPage(WebDriver ldriver) {
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
	@FindBys(@FindBy(xpath = "//ul[@id='product_listing']//h4//a"))
	public List<WebElement> itemheading;
	@FindBy(xpath = "//div[@class='content_product_detail']//h1")
	public WebElement productname;
	@FindBy(xpath = "//div[@class='content_product_detail']//span[@class='woocommerce-Price-amount amount']")
	public WebElement productprice;
	@FindBys(@FindBy(xpath = "//ul[@class='breadcrumb']//li//a"))
	public List<WebElement> toppages;
	@FindBy(xpath = "//div[@class='quantity buttons_added']//input[@class='minus']")
	public WebElement minus;
	@FindBy(xpath = "//div[@class='quantity buttons_added']//input[@type='number']")
	public WebElement quantity;
	@FindBy(xpath = "//div[@class='quantity buttons_added']//input[@class='plus']")
	public WebElement plus;
	@FindBy(xpath = "//form[@class='cart']//button[@name='add-to-cart']")
	public WebElement addtocart;
	@FindBy(xpath = "//a[@class='button-buynow']")
	public WebElement buynow;

	public void gotoeachitem() throws InterruptedException {
		String itemname = null;
			for (int j = 0; j < itemheading.size(); j++) {
				itemheading.get(j).click();
				Thread.sleep(2000);
				itemname = productname.getText();
				HashMap<Object, Object> itemdetails = CommonUtils.readjsondata(
						System.getProperty("user.dir") + "/src/main/resources/itempricedetailsjsonfiles/Papad.json",
						"Name of the Item", itemname);
				if (!itemdetails.isEmpty()) {
					Thread.sleep(2000);
					double expectedprice = CommonUtils.convertdo(itemdetails.get("Cost").toString());
					double actualvalprice = CommonUtils.convertdo2(productprice.getText());
					Assert.assertEquals(expectedprice, actualvalprice);
				} else {
					System.out.println("Item Not Available " + itemname);
				}
				driver.navigate().back();
				Thread.sleep(2000);
			}
		}

	public void selectitem(String item) {
		for (int j = 0; j < itemheading.size(); j++) {
			
			if(itemheading.get(j).getText().equalsIgnoreCase(item)) {
				itemheading.get(j).click();
			}
			
		}
	}
	
	public void addtocart() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		addtocart.click();
	}
}
