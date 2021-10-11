package com.homeaharaa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {

	static WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public HomePage(WebDriver ldriver) {
		driver = ldriver;

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

	@FindBys(@FindBy(xpath = "//div[@id='contents']//section//div[contains(@id,'latest_sw_woo_tab_slider')]"))
	public List<WebElement> allsections;

	public SweetPage sweetpage() {

		return new SweetPage(driver);

	}

	public SnackPage snackpage() {

		return new SnackPage(driver);

	}

	public GroceriesPage groceriespage() {

		return new GroceriesPage(driver);

	}

	public CustomPowderPage custompowderpage() {

		return new CustomPowderPage(driver);

	}

	public ReadyPowderPage readypowderpage() {

		return new ReadyPowderPage(driver);

	}

	public PapadPage papadpage() {

		return new PapadPage(driver);

	}

	public UtensilsPage utensilspage() {

		return new UtensilsPage(driver);

	}
	
	//Methods
	
	public ReadyPowderPage clickReadymadePowder() {
		Actions act = new Actions(driver);
		act.moveToElement(spicesdropdown).perform();
		readymadepowderdropdown.click();
		return new ReadyPowderPage(driver);
	}

}
