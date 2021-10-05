package com.mycustomgun.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import com.mycustomgun.TestBase.TestBase;
import com.mycustomgun.Utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {

	WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;

	}

	@FindBy(css = "ul.header-menu span.v-chip__content")
	@CacheLookup
	public WebElement MCGAccount;
	@FindBy(css = "form.v-form input[autocomplete='username']")
	public WebElement emailid;
	@FindBy(css = "form.v-form input[autocomplete='current-password']")
	public WebElement password;
	@FindBy(css = "div.v-input__append-inner button")
	public WebElement hiddenicon;
	@FindBy(css = "button.v-btn:nth-child(1)")
	public WebElement login;
	@FindBy(css = "form.v-form button:nth-child(2)")
	public WebElement signup;
	@FindBys(@FindBy(css = "form div.v-text-field__slot input:nth-child(2)"))
	public List<WebElement> registerform;
	@FindBy(css = "header a[href='/gun_builder']")
	public WebElement buildgun;
	@FindBy(css = "ul.header-menu a[href='/cart']")
	public WebElement cart;
	
	
	public void clickLogin() throws InterruptedException {
		seleutils.javascriptClick(MCGAccount, driver, "Click to login");
		Thread.sleep(2000);
	}

	public void Login() throws InterruptedException {
		clickLogin();
		seleutils.seleSendKeys(emailid, "admin@mycg.com", "Enter Email",driver);
		emailid.sendKeys(Keys.TAB);
		seleutils.seleSendKeys(password, "admin@mycg.com", "Enter Email",driver);
		password.sendKeys(Keys.TAB);
		hiddenicon.sendKeys(Keys.TAB);
		login.sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Login Successfull" + test.addScreenCapture(takeScreenshot(driver)));
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev.mycustomgun.com/");
	}
	
	public void Login(String username,String pwd) throws InterruptedException {
		clickLogin();
		seleutils.javascriptClick(emailid, driver, "Click to login");
		seleutils.seleSendKeys(emailid, username, "Enter Email",driver);
		emailid.sendKeys(Keys.TAB);
		seleutils.seleSendKeys(password, pwd, "Enter Password",driver);
		password.sendKeys(Keys.TAB);
		hiddenicon.sendKeys(Keys.TAB);
		login.sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Login Successfull" + test.addScreenCapture(takeScreenshot(driver)));
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev.mycustomgun.com/");
	}
	
	public void clickGunbuilder() throws InterruptedException {
		seleutils.javascriptClick(buildgun, driver, "Click to GunBuiler");
		Thread.sleep(2000);
	}
	
}
