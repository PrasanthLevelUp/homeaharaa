package com.homeaharaa.TestRunner.web;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.pages.HomePage;
import com.homeaharaa.pages.ReadyPowderPage;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(com.info.TestRunner.Listner.class)
public class TC_ReadymadePowders extends TestBase {

	HomePage homepage;
	ReadyPowderPage readymade;
	WebDriver driver;

	@BeforeClass(groups = {"Regression"})
	public void launchApp() {
		driver = startBrowser(prop.getProperty("broswer"), prop.getProperty("base_url"));
		homepage = PageFactory.initElements(driver, HomePage.class);
		getDatas(this.getClass().getSimpleName());
	}

	@Test(description = "This test case will validate login")
	public void customer_Registraion() throws InterruptedException {
		try {
			test = report.startTest(getData("Description"));
			test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
			readymade=homepage.clickReadymadePowder();
			
		} catch (Exception ex) {
			System.out.println("Msg" + ex.getMessage());
		}
	}

	@AfterClass(groups = {"Regression"})
	public void endApp() {
		driver.close();
	}

}
