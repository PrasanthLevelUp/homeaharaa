package com.homeaharaa.TestRunner.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.pages.HomePage;
import com.homeaharaa.pages.SnackPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC1_SnacksPriceValidation extends TestBase{
	
	HomePage homepage;
	WebDriver driver;
	SnackPage snackPage;

	@BeforeClass
	public void launchApp() {
		driver = startBrowser("chrome","https://homeaharaa.com/");
		homepage = new HomePage(driver);
	}

	@Test(priority = 1, description = "Validate all the items")
	public void validatesnackitems() throws InterruptedException {
		try {
			//test = report.startTest(getData("Description"));
			//test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
			//homepage.Login();
			homepage.popup();
			snackPage = homepage.snackpage();
			snackPage.gotoeachitem();
			
			
		} catch (Exception ex) {
			System.out.println("Msg" + ex.getMessage());
		}
	}

	@AfterClass
	public void endApp() {
		driver.close();
	}


}
