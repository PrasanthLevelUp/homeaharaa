package com.homeaharaa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	WebDriver driver;
	SeleniumUtils seleutils = new SeleniumUtils();

	public HomePage(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//div[@class='elementor-widget-container']//span[contains(text(),'Login')]")
	@CacheLookup
	public WebElement topLogin;
	@FindBy(xpath = "//form[@id='login_ajax']//a[@title='Register']")
	public WebElement register;
	@FindBy(xpath = "//form[@id='login_ajax']//input[@id='username']")
	public WebElement username;
	@FindBy(xpath = "//form[@id='login_ajax']//input[@id='password']")
	public WebElement password;
	@FindBy(xpath = "//form[@id='login_ajax']//input[@name='login']")
	public WebElement loginbutton;
	@FindBy(xpath = "//form[@id='login_ajax']//div[@id='login_message']")
	public WebElement loginmessage;
	@FindBy(xpath = "//div[@id='popmake-8024']//button")
	public WebElement popup;
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
	@FindBy(xpath = "//ul[@class='dropdown-menu']//span[contains(text(),'Readymade Spice Mix')]")
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
	@FindBy(xpath = "//div[contains(@class,'elementor-element')]//a[@title='Cart']")
	public WebElement viewcart;
	

	// div[@id='contents']//section//div[@id='latest_sw_woo_tab_slider_1']//div[
	// @aria-hidden='false']//h4//a

	@FindBys(@FindBy(xpath = "//div[@id='contents']//section//div[contains(@id,'latest_sw_woo_tab_slider')]"))
	public List<WebElement> allsections;
	
	
	public void searchproduct(String name) {
		searchbox.click();
		searchbox.sendKeys(name);
		searchbtn.click();
	}
	
	public void popup() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(popup)).click();;
	}

	public Object selectitem(String category) {
		
		switch(category) {
		case "Sweet":
			 SeleniumUtils.movetoitem(driver, sweetandsnack);
			 sweetdropdown.click();
			 return new SweetPage(driver);
		
		case "Snack":
			SeleniumUtils.movetoitem(driver, sweetandsnack);
			sweetdropdown.click();
			return new SnackPage(driver);
		case  "Groceries":
			SeleniumUtils.movetoitem(driver, spicesdropdown);
			groceriesdropdown.click();
			return new GroceriesPage(driver);
		}
		
		
		return driver;
		
		
	}
	
	public SweetPage sweetpage() {
		Actions action = new Actions(driver);
		action.moveToElement(sweetandsnack).build().perform();
		sweetdropdown.click();

		return new SweetPage(driver);

	}

	public SnackPage snackpage() {
		Actions action = new Actions(driver);
		action.moveToElement(sweetandsnack).build().perform();
		snackdropdown.click();
		
		return new SnackPage(driver);

	}

	public GroceriesPage groceriespage() {
		Actions action = new Actions(driver);
		action.moveToElement(spicesdropdown).build().perform();
		groceriesdropdown.click();

		return new GroceriesPage(driver);

	}

	public CustomPowderPage custompowderpage() {

		return new CustomPowderPage(driver);

	}

	public ReadyPowderPage readypowderpage() {
		Actions action = new Actions(driver);
		action.moveToElement(spicesdropdown).build().perform();
		readymadepowderdropdown.click();
		return new ReadyPowderPage(driver);

	}

	public PapadPage papadpage() {
		Actions action = new Actions(driver);
		action.moveToElement(spicesdropdown).build().perform();
		papaddropdown.click();

		return new PapadPage(driver);

	}

	public UtensilsPage utensilspage() {
		utensilsdropdown.click();

		return new UtensilsPage(driver);

	}
	
	//Methods
	
	public ReadyPowderPage clickReadymadePowder() {
		Actions act = new Actions(driver);
		act.moveToElement(spicesdropdown).perform();
		readymadepowderdropdown.click();
		return new ReadyPowderPage(driver);
	}
	
	public CartPage clickCartPage() {
		Actions act = new Actions(driver);
		act.moveToElement(carticon).perform();
		viewcart.click();
		return new CartPage(driver);
	}
	
	public MyAccountPage clickCreateAccount() throws InterruptedException {
		topLogin.click();
		Thread.sleep(2000);
		register.click();
		Thread.sleep(2000);
		return new MyAccountPage(driver);
	}
	
	public HomePage loginuser() throws InterruptedException {
		topLogin.click();
		Thread.sleep(2000);
		username.sendKeys("10prasanth1994@gmail.com");
		password.sendKeys("Niho@2020");
		loginbutton.click();
		Thread.sleep(2000);
		if(loginmessage.isDisplayed()) {
			System.out.println("Error");
		}else {
			System.out.println("Successfully");
		}
		return new HomePage(driver);
	}

}
