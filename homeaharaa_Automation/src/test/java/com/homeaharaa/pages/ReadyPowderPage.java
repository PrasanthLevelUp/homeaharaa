package com.homeaharaa.pages;

import java.util.List;

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
	
	
	@FindBys(@FindBy(xpath = "//div[@id='contents']//section//div[contains(@id,'latest_sw_woo_tab_slider')]"))
	public List<WebElement> allsections;
	//object for Product Names
	@FindBy(xpath = "//*[contains(@class,'item-content')]/h4/a")
	public List<WebElement> allProductName;
	//object for Add to cart
	@FindBy(xpath = "//a[@title='Add To Cart']")
	public List<WebElement> allAddToCart;
	//Object for pagination
	@FindBy(xpath = "//*[contains(@class,'page-numbers')]/li")
	public List<WebElement> pagination;
	
	
}
