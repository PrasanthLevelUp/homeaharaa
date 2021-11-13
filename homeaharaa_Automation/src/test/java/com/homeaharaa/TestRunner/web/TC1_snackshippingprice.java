package com.homeaharaa.TestRunner.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.pages.CartPage;
import com.homeaharaa.pages.HomePage;
import com.homeaharaa.pages.PapadPage;
import com.homeaharaa.pages.SnackPage;
import com.homeaharaa.pages.SweetPage;
import com.homeaharaa.pages.UtensilsPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC1_snackshippingprice extends TestBase{
	
	HomePage homepage;
	WebDriver driver;
	SnackPage snackPage;
	CartPage cartpage;

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
			snackPage = homepage.snackpage();
			snackPage.selectitem("Garlic Mixture");
			snackPage.addtocart("250g");
			homepage = new HomePage(driver);
			homepage.clickCartPage();
			cartpage = new CartPage(driver);
			//cartpage.validateshipprice("India_Delhi");
			cartpage.validateshippingprice("India_Delhi","Delhi","Chennai","603110");		
			
		} catch (Exception ex) {
			System.out.println("Msg" + ex.getMessage());
		}
	}

	@AfterClass
	public void endApp() {
		driver.close();
	}


}
