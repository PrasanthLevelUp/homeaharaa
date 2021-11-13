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

public class CheckoutPage extends TestBase {

	static WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public CheckoutPage(WebDriver ldriver) {
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

	// div[@id='contents']//section//div[@id='latest_sw_woo_tab_slider_1']//div[
	// @aria-hidden='false']//h4//a
	public WebElement buynow;
	@FindBy(xpath = "//input[@id='billing_first_name']")
	public WebElement billingFN;
	@FindBy(xpath = "//input[@id='billing_last_name']")
	public WebElement billingLN;
	@FindBy(xpath = "//input[@id='billing_company']")
	public WebElement billingcompany;
	@FindBy(xpath = "//select[@id='billing_country']")
	public WebElement billingCountry;
	@FindBy(xpath = "//input[@id='billing_address_1']")
	public WebElement billingAddress1;
	@FindBy(xpath = "//input[@id='billing_address_2']")
	public WebElement billingAddress2;
	@FindBy(xpath = "//input[@id='billing_city']")
	public WebElement billingCity;
	@FindBy(xpath = "//select[@id='billing_state']")
	public WebElement billingState;
	@FindBy(xpath = "//input[@id='billing_postcode']")
	public WebElement billingPin;
	@FindBy(xpath = "//input[@id='billing_phone']")
	public WebElement billingPhone;
	@FindBy(xpath = "//input[@id='billing_email']")
	public WebElement billingEmail;
	@FindBy(xpath = "//input[@id='createaccount']")
	public WebElement billingCreateAccount;
	@FindBys(@FindBy(xpath = "//tr[@class='cart_item']//td[@class='product-name']"))
	public List<WebElement> addeditemsname;
	@FindBys(@FindBy(xpath = "//tr[@class='cart_item']//td[@class='product-total']/span"))
	public List<WebElement> addeditemsprice;
	@FindBy(xpath = "//tr[@class='cart-subtotal']/td/span")
	public WebElement billingSubtotal;
	@FindBy(xpath = "//tr[@class='tax-total']/td/span")
	public WebElement billingVAT;
	@FindBy(xpath = "//tr[@class='order-total']/td/strong/span")
	public WebElement billingTotal;
	@FindBy(xpath = "//tr[@class='shipping']/td/span")
	public WebElement billingTotalOrderWeight;

	
}
