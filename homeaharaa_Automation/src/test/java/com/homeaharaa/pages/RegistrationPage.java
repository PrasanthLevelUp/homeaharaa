package com.homeaharaa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.CommonUtils;
import com.homeaharaa.Utils.NadaEMailService;
import com.homeaharaa.Utils.SeleniumUtils;

public class RegistrationPage extends TestBase{
	
	
	WebDriver driver;
	HomePage homepage;
	
	SeleniumUtils seleutils = new SeleniumUtils();
	CommonUtils commonutils = new CommonUtils();
	NadaEMailService otpserivice = new NadaEMailService();

	public RegistrationPage(WebDriver ldriver) {
		this.driver = ldriver;		
	}

	@FindBy(css = "form.v-form button:nth-child(2)")
	public WebElement signup;
	@FindBys(@FindBy(css = "form div.v-text-field__slot input:nth-child(2)"))
	public List<WebElement> registerform;
	@FindBy(css = "form div input[role='checkbox']")
	public WebElement checkbox;
	@FindBy(css = "form button.success")
	public WebElement registerbtn;
	@FindBy(css = "div.v-dialog  input")
	public WebElement otp;
	@FindBys(@FindBy(css = "div.v-dialog  button"))
	public List<WebElement> verifybtn;
	
	public void Signup(String FN,String LN,String Email,String pwd) throws InterruptedException {
		seleutils.javascriptClick(signup, driver, "Click to signup");
		Thread.sleep(2000);
		seleutils.javascriptClick(registerform.get(0), driver, "Click on First Name");
		seleutils.seleSendKeys(registerform.get(0), FN, "Enter First Name",driver);
		seleutils.javascriptClick(registerform.get(1), driver, "Click on Last Name");
		seleutils.seleSendKeys(registerform.get(1), LN, "Enter Last Name",driver);
		seleutils.javascriptClick(registerform.get(2), driver, "Click on Email Name");
		seleutils.seleSendKeys(registerform.get(2),Email , "Enter Email",driver);
		seleutils.javascriptClick(registerform.get(3), driver, "Click on Password Name");
		seleutils.seleSendKeys(registerform.get(3), pwd, "Enter Password Name",driver);
		seleutils.javascriptClick(registerform.get(4), driver, "Click on Confirm Password");
		seleutils.seleSendKeys(registerform.get(4), pwd, "Enter Confirm Password",driver);
		seleutils.javascriptClick(checkbox, driver, "Click on Terms of Services");
		seleutils.javascriptClick(registerbtn, driver, "Click on Registration");
		Thread.sleep(10000);
		seleutils.seleSendKeys(otp, otpserivice.getOTP(Email), "Enter OTP",driver);
		seleutils.javascriptClick(verifybtn.get(1), driver, "Click on Verify");
		Thread.sleep(2000);
		homepage = new HomePage(driver);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev.mycustomgun.com/login");
	}
	
	public void fillExcel() throws IOException {
	String Email = commonutils.getEmailId();
	String Password = commonutils.generatePassword();
	setData("FirstName",commonutils.generateName());
	setData("LastName",commonutils.generateName());
	setData("Email",Email);
	setData("LoginUserName",Email);
	setData("Password",Password);
	setData("LoginPassword",Password);
	}

}
