package com.homeaharaa.TestRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {
	
	WebDriver driver;
	
	
	@Test
	@Parameters("browser")
	public void ParallelExecution(String browsername)
	{
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E://StudyWorkpace//ExtentReport_Demo//Drivers//chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		
		driver.get("file:///E:/StudyWorkpace/ExtentReport_Demo/HTML_Pages/Registration.html");
	}
	

}
