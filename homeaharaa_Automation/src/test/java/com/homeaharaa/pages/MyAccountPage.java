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

public class MyAccountPage {

	WebDriver driver;
	SeleniumUtils seleutils = new SeleniumUtils();

	public MyAccountPage(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	public WebElement buynow;
	@FindBy(xpath = "//input[@id='billing_first_name']")
	public WebElement billingFN;
	@FindBy(xpath = "//input[@id='billing_last_name']")
	public WebElement billingLN;
	@FindBy(xpath = "//input[@id='reg_email']")
	public WebElement billingEmail;
	@FindBy(xpath = "//input[@id='reg_password']")
	public WebElement billingPassword;
	@FindBy(xpath = "//button[@name='register']")
	public WebElement billingRegister;
	@FindBy(xpath = "//input[@id='user_login']")
	public WebElement billinguserlogin;
	@FindBy(xpath = "///input[@id='user_pass']")
	public WebElement billinguserpass;
	@FindBy(xpath = "//input[@id='wp-submit']")
	public WebElement billingLogin;
	@FindBy(xpath = "//div[@id='login_error']")
	public WebElement loginerror;
	

	// div[@id='contents']//section//div[@id='latest_sw_woo_tab_slider_1']//div[
	// @aria-hidden='false']//h4//a

	@FindBys(@FindBy(xpath = "//div[@id='contents']//section//div[contains(@id,'latest_sw_woo_tab_slider')]"))
	public List<WebElement> allsections;
	
	
	public void registnewuser() throws InterruptedException {
		billingFN.sendKeys("AutomationTest");
		billingLN.sendKeys("Testing");
		billingEmail.sendKeys("10prasanth1994@gmail.com");
		billingPassword.sendKeys("Prasanth@2020");
		billingRegister.click();
		Thread.sleep(3000);
	}
	
	public void loginnewaccount() {
		billinguserlogin.sendKeys("10prasanth1994@gmail.com");
		billinguserpass.sendKeys("Prasanth@2020");
		billingLogin.click();
	}
	
	
	}
