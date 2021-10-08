package com.homeaharaa.Utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.homeaharaa.TestBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumUtils extends TestBase {

	CommonUtils comutils = new CommonUtils();
	
	
	public String takeScreenShot(WebDriver driver) {
		String screen = " ";
		if(prop.getProperty("screenshot").equalsIgnoreCase("true")){
			screen = test.addScreenCapture(takeScreenshot(driver));		
		}
		return screen;
	}
	

	public void javascriptClick(WebElement ele, WebDriver driver, String desc) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			test.log(LogStatus.PASS, desc + test.addScreenCapture(takeScreenshot(driver)));
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.getMessage() + test.addScreenCapture(takeScreenshot(driver)));
		}
	}

	public String javascriptgetTextbyval(WebElement ele, WebDriver driver) {
		String returnText = null;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			returnText = (String) executor.executeScript("return arguments[0].value", ele);
			test.log(LogStatus.PASS, "Returned value is " + returnText + test.addScreenCapture(takeScreenshot(driver)));
			return returnText;
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.getMessage() + test.addScreenCapture(takeScreenshot(driver)));
			return returnText;
		}
	}

	public String javascriptgetTextbyInnerHtml(WebElement ele, WebDriver driver) {
		String returnText = null;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			returnText = (String) executor.executeScript("return arguments[0].innerHTML", ele);
			test.log(LogStatus.PASS, "Returned value is " + returnText + test.addScreenCapture(takeScreenshot(driver)));
			return returnText;
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.getMessage() + test.addScreenCapture(takeScreenshot(driver)));
			return returnText;
		}
	}
	
	public void javascriptClearText(WebElement ele, WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value ='';", ele);
			test.log(LogStatus.PASS, "Clear Text "+ test.addScreenCapture(takeScreenshot(driver)));
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.getMessage() + test.addScreenCapture(takeScreenshot(driver)));
		}
	}

	public void seleSendKeys(WebElement ele, String val, String desc,WebDriver driver) {
		try {
			ele.sendKeys(val);
			test.log(LogStatus.PASS, desc + test.addScreenCapture(takeScreenshot(driver)));
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.getMessage() + test.addScreenCapture(takeScreenshot(driver)));

		}
	}
	public void JsSendKeys(WebElement ele, String val, String desc,WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value='"+val+"'", ele); 
			test.log(LogStatus.PASS, desc + test.addScreenCapture(takeScreenshot(driver)));
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.getMessage() + test.addScreenCapture(takeScreenshot(driver)));

		}
	}

	public void asserstEqualsvalues(String Expected, String Actual) {
		try {
			Assert.assertEquals(Actual, Expected);
			test.log(LogStatus.PASS, "Assertion Expeced values is " + Expected + " Actual Values is " + Actual
					+ test.addScreenCapture(takeScreenshot(driver)));
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Assertion Expeced values is " + Expected + " Actual Values is " + Actual
					+ test.addScreenCapture(takeScreenshot(driver)));
		}
	}

	public void priceChecker(String expectedval, WebElement ele, WebDriver driver) {
		String Actualprice = javascriptgetTextbyInnerHtml(ele.findElement(By.cssSelector("p")), driver);
		String Actualprice1 = comutils.priceValidation(Actualprice.trim());
		asserstEqualsvalues(expectedval, Actualprice1);
	}

	public void speficationValidationname(String expectedval, WebElement ele, WebDriver driver) {
		String actualval = javascriptgetTextbyInnerHtml(ele, driver);
		asserstEqualsvalues(expectedval, actualval);
	}
	
	public void speficationValidation(String expectedname,String expectedprice, WebElement name, WebElement price,WebDriver driver) {
		speficationValidationname(expectedname,name,driver);
		speficationValidationprice(expectedprice,price,driver);
	}

	public void speficationValidationprice(String expectedval, WebElement ele, WebDriver driver) {
		String actualval = javascriptgetTextbyInnerHtml(ele, driver);
		String actualval1 = comutils.speficationPrice(actualval);
		String expectedval1 = expectedval.substring(0, expectedval.length() - 3);
		asserstEqualsvalues(expectedval1, actualval1);
	}

	public void validateprice(WebElement curreneprice, WebElement ele, WebDriver driver) {
		// Added Item Price
		String Actualprice = javascriptgetTextbyInnerHtml(ele.findElement(By.cssSelector("p")), driver).trim();
		String Actualprice1 = comutils.priceValidation(Actualprice.trim());
		String currentPrice = getData("Current_Price");
		String AddedValue = comutils.addPrice(currentPrice, Actualprice1);

		// Total Price
		String Totalprice = javascriptgetTextbyInnerHtml(curreneprice, driver).trim();
		String Totalprice1 = comutils.TotalpriceValidation(Totalprice);

		asserstEqualsvalues(AddedValue, Totalprice1);
		try {
			setData("Current_Price", AddedValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
		public void validateprice1(WebElement curreneprice, WebElement ele, WebDriver driver) {
			// Added Item Price
			String Actualprice = javascriptgetTextbyInnerHtml(ele.findElement(By.cssSelector("p")), driver).trim();
			String Actualprice1 = comutils.priceValidation(Actualprice.trim());
			String currentPrice = getData("Current_Price");
			String AddedValue = comutils.addPrice(currentPrice, Actualprice1);

			// Total Price
			String Totalprice = javascriptgetTextbyInnerHtml(curreneprice, driver).trim();
			String Totalprice1 = comutils.TotalpriceValidation1(Totalprice);

			asserstEqualsvalues(AddedValue, Totalprice1);
			try {
				setData("Current_Price", AddedValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
	
	public void validatepriceColorsplash(WebElement curreneprice, WebElement ele, WebDriver driver) {
		// Added Item Price
		String Actualprice = javascriptgetTextbyInnerHtml(ele, driver).trim();
		String Actualprice1 = comutils.speficationPrice(Actualprice.trim());
		String currentPrice = getData("Current_Price");
		String AddedValue = comutils.addPricecolor(currentPrice, Actualprice1);

		// Total Price
		String Totalprice = javascriptgetTextbyInnerHtml(curreneprice, driver).trim();
		String Totalprice1 = comutils.TotalpriceValidation(Totalprice);
		
		String reduceedTotal = comutils.reducetotal(AddedValue,getData("Bolt_Carrier_Group_Price"));

		asserstEqualsvalues(reduceedTotal, Totalprice1);
		try {
			setData("Current_Price", reduceedTotal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void validatepriceColor(WebElement curreneprice, WebElement ele, WebDriver driver) {
		// Added Item Price
		String Actualprice = javascriptgetTextbyInnerHtml(ele, driver).trim();
		String Actualprice1 = comutils.speficationPrice(Actualprice.trim());
		String currentPrice = getData("Current_Price");
		String AddedValue = comutils.addPricecolor(currentPrice, Actualprice1);
		
		// Total Price
		String Totalprice = javascriptgetTextbyInnerHtml(curreneprice, driver).trim();
		String Totalprice1 = comutils.TotalpriceValidation1(Totalprice);

		asserstEqualsvalues(AddedValue, Totalprice1);
		try {
			setData("Current_Price", AddedValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void TotalpriceChecker(String expectedval, WebElement ele, WebDriver driver) throws IOException {
		String Actualprice = javascriptgetTextbyInnerHtml(ele, driver).trim();
		String Actualprice1 = comutils.TotalpriceValidation(Actualprice);
		setData("Current_Price", Actualprice1);
		asserstEqualsvalues(expectedval, Actualprice1);
	}

}
