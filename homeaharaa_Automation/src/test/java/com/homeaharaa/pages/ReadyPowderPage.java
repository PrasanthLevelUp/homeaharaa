package com.homeaharaa.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class ReadyPowderPage extends TestBase {

	static WebDriver driver;

	SeleniumUtils seleutils = new SeleniumUtils();

	public ReadyPowderPage(WebDriver ldriver) {
		this.driver = ldriver;

	}


	@FindBy(xpath = "//li/span[text()='Readymade Powders']")
	public WebElement txtCarosel;
	
	@FindBy(xpath = "//h1[text()='Readymade Powders']")
	public WebElement txtPageHeader;
	
	@FindBy(xpath = "//*[@class='current']/a")
	public WebElement lnkProductCount;
	
	
	
	//object for Products
	@FindBys(@FindBy(xpath = "//div[@class='item-detail']"))
	public List<WebElement> allProducts;
	
	//object for Product Names
	@FindBys(@FindBy(xpath = "//*[contains(@class,'item-content')]/h4/a"))
	public List<WebElement> allProductName;
	
	//object for Add to cart
	@FindBys(@FindBy(xpath = "//a[@title='Add To Cart']"))
	public List<WebElement> allAddToCart;
	
	//Object for pagination
	@FindBys(@FindBy(xpath = "//*[contains(@class,'page-numbers')]//a"))
	public List<WebElement> pagination;
	
	
	
	
	
	//Methods
	
	//To verify the Carosel Header of ReadyMade Powder
	
	public void assertCarosel() {
		Assert.assertTrue(txtCarosel.isDisplayed(), "Readymade Powder in carosel is not displayed");
	}
	
	public void assertPageHeader() {
		Assert.assertTrue(txtPageHeader.isDisplayed(), "Readymade Powder in page header is not displayed");
	}
	
	public void assertProductCount() {
		String productCount= lnkProductCount.getText();
		int currentcount=Integer.parseInt(productCount);
		for(int i=2; i<=pagination.size()-1; i++) {
			Assert.assertTrue(allProducts.size()<= currentcount, "Product count is more than current page count");
				driver.findElement(By.xpath("//*[contains(@class,'page-numbers')]//a["+i+"]")).click();
				
			}
		txtCarosel.click();
		}
		
	
	
}
