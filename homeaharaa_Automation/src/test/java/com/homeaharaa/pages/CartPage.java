package com.homeaharaa.pages;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
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

public class CartPage extends TestBase {

	static WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public CartPage(WebDriver ldriver) {
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
	@FindBys(@FindBy(xpath = "//tr[@class='woocommerce-cart-form__cart-item cart_item']//td[@class='product-name']//a"))
	public List<WebElement> productnamesincart;
	@FindBys(@FindBy(xpath = "//tr[@class='woocommerce-cart-form__cart-item cart_item']//td[@class='product-price']/span"))
	public List<WebElement> productpricesincart;
	@FindBys(@FindBy(xpath = "//tr[@class='woocommerce-cart-form__cart-item cart_item']//td[@class='product-quantity']//input[@type='number']"))
	public List<WebElement> productquantitysincart;
	@FindBys(@FindBy(xpath = "//tr[@class='woocommerce-cart-form__cart-item cart_item']//td[@class='product-subtotal']/span"))
	public List<WebElement> productsubtotalsincart;
	@FindBys(@FindBy(xpath = "//td[@class='product-quantity']//input[@class='plus']"))
	public List<WebElement> productplus;
	@FindBy(xpath = "//a[@class='shipping-calculator-button']")
	public WebElement Calculateshipping;
	@FindBy(xpath = "//select[@id='calc_shipping_country']")
	public WebElement countryselection;
	@FindBy(xpath = "//select[@id='calc_shipping_state']")
	public WebElement stateselection;
	@FindBy(xpath = "//input[@id='calc_shipping_city']")
	public WebElement city;
	@FindBy(xpath = "//input[@id='calc_shipping_postcode']")
	public WebElement postcode;
	@FindBy(xpath = "//button[@name='calc_shipping']")
	public WebElement shippingbtn;
	@FindBy(xpath = "//ul[@id='shipping_method']//span[@class='woocommerce-Price-amount amount']")
	public WebElement currentshippingprice;
	@FindBy(xpath = "//tr[@class='shipping']//span")
	public WebElement totalshipping;

	public void validateitem(String expecteditemname, int expectedprice) throws InterruptedException {

		Thread.sleep(5000);
		for (int i = 0; i < productnamesincart.size(); i++) {

			if (productnamesincart.get(i).getText().equalsIgnoreCase(expecteditemname)) {
				double actualvalprice = CommonUtils.convertdo2(productpricesincart.get(i).getText());
				Assert.assertEquals(actualvalprice, expectedprice);
				double actualvalquantity = Double.parseDouble(productquantitysincart.get(i).getAttribute("value"));
				double expectedsubtotal = actualvalprice * actualvalquantity;
				double actualsubtotal = CommonUtils.convertdo2(productsubtotalsincart.get(i).getText());
				Assert.assertEquals(actualsubtotal, expectedsubtotal);
			}
		}

	}

	public HashMap<Object, Object> getprices(String country) throws InterruptedException {
		HashMap<Object, Object> itemdetails = CommonUtils.readjsondata(
				System.getProperty("user.dir") + "/src/main/resources/itempricedetailsjsonfiles/Shipping.json",
				"WEIGHT", country);
		if (!itemdetails.isEmpty()) {
			return itemdetails;
		} else {
			System.out.println("Country Not Available " + country);
			return null;
		}
	}

	public void selectshipping(String Country,String state,String cityname,String pincode) throws InterruptedException {
		Calculateshipping.click();
		Thread.sleep(2000);
		seleutils.selectbyvisbiletext(countryselection, Country);
		seleutils.selectbyvisbiletext(stateselection, state);
		city.sendKeys(cityname);
		postcode.sendKeys(pincode);
		shippingbtn.click();
		Thread.sleep(2000);
	}

	public void validateshippingprice(String country,String state,String cityname,String pincode) throws InterruptedException {
		HashMap<Object, Object> itemdetails = this.getprices(country);
		if(country.contains("India")) {
			
			String[] shippingdetails = country.split("_");
			this.selectshipping(shippingdetails[0],state,cityname,pincode);
		}else {
			this.selectshipping(country,state,cityname,pincode);
		}
	
		for (int i = 0; i < 45; i++) {
			Double actualshippingprice = CommonUtils.convertdo2(currentshippingprice.getText());
			double actualshippingweight = CommonUtils.covertdoubl3(totalshipping.getText());
			Double weightround = CommonUtils.roundToHalf(actualshippingweight);
			if (weightround >= 21) {
				Object expectedweightprice = itemdetails.get("21 - 44");
				Assert.assertEquals(actualshippingprice.toString(), expectedweightprice.toString());
			} else {
				Object expectedweightprice = itemdetails.get(weightround.toString());
				Assert.assertEquals(actualshippingprice.toString(), expectedweightprice.toString());
			}
			productplus.get(0).click();
			Thread.sleep(3000);
		}

	}

}
