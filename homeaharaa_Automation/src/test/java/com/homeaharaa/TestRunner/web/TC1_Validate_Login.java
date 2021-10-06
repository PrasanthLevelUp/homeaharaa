package com.homeaharaa.TestRunner.web;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(com.info.TestRunner.Listner.class)
public class TC1_Validate_Login extends TestBase {

	HomePage homepage;
	WebDriver driver;

	@BeforeClass(groups = {"Regression"})
	public void launchApp() {
		driver = startBrowser(prop.getProperty("broswer"), prop.getProperty("base_url"));
		homepage = PageFactory.initElements(driver, HomePage.class);
		getDatas(this.getClass().getSimpleName());
	}

	@Test(priority = 1, description = "This test case will validate login",groups = {"Login","Regression","All"})
	public void customer_Registraion() throws InterruptedException {
		try {
			test = report.startTest(getData("Description"));
			test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
			//homepage.Login();
			
		} catch (Exception ex) {
			System.out.println("Msg" + ex.getMessage());
		}
	}

	@AfterClass(groups = {"Regression"})
	public void endApp() {
		driver.close();
	}

}
