package com.homeaharaa.TestRunner.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.pages.CartPage;
import com.homeaharaa.pages.HomePage;
import com.homeaharaa.pages.MyAccountPage;
import com.homeaharaa.pages.PapadPage;
import com.homeaharaa.pages.SnackPage;
import com.homeaharaa.pages.SweetPage;
import com.homeaharaa.pages.UtensilsPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC1_RegistNewUser extends TestBase{
	
	HomePage homepage;
	WebDriver driver;
	MyAccountPage myaccountPage;
	
	@BeforeClass
	public void launchApp() {
		driver = startBrowser("chrome","https://homeaharaa.com/");
		homepage = new HomePage(driver);
	}

	@Test(priority = 1, description = "Validate all the items")
	public void validatesweetitems() throws InterruptedException {
		try {
			//test = report.startTest(getData("Description"));
			//test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
			//homepage.Login();
			homepage.popup();
			myaccountPage = homepage.clickCreateAccount();
			myaccountPage.registnewuser();
			myaccountPage.loginnewaccount();
			
		} catch (Exception ex) {
			System.out.println("Msg" + ex.getMessage());
		}
	}

	@AfterClass
	public void endApp() {
		driver.close();
	}


}
