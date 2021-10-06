package com.mycustomgun.TestRunner.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mycustomgun.TestBase.TestBase;
import com.mycustomgun.pages.HomePage;
import com.mycustomgun.pages.RegistrationPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC2_Registratino_Form extends TestBase{

	HomePage homepage;
	RegistrationPage registrationpage;
	WebDriver driver;

	@BeforeClass(groups = {"Regression"})
	public void launchApp() {
		driver = startBrowser("Chrome", "https://dev.mycustomgun.com");
		homepage = PageFactory.initElements(driver, HomePage.class);	
		getDatas(this.getClass().getSimpleName());

	}

	@Test(priority = 1, description = "This test case will Register a user",groups = {"Regression"})
	public void customer_Registraion() throws InterruptedException {
		try {
			test = report.startTest(getData("Description"));
			test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());		
		} catch (Exception ex) {
			System.out.println("Msg" + ex.getMessage());
		}

	}

	@AfterClass(groups = {"Regression"})
	public void endApp() {
		driver.close();
	}


}
