package com.homeaharaa.TestRunner.web;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.Utils.SeleniumUtils;
import com.homeaharaa.pages.GroceriesPage;
import com.homeaharaa.pages.HomePage;
import com.homeaharaa.pages.SpiceMix;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner extends TestBase {

    @Test(dataProviderClass = GroceriesPage.class, dataProvider = "Product-Rates",enabled = false)
    public void Grocaries(String a, ArrayList<HashMap<String, String>> ar) {
        driver = startBrowser(prop.getProperty("broswer"), prop.getProperty("base_url"));
        SeleniumUtils su = new SeleniumUtils();
        HomePage hp = new HomePage(driver);
        hp.closepopup();
        GroceriesPage b = hp.groceriespage();
        for (HashMap<String, String> maps : ar) {
            b.selectProduct(maps.get("NAME OF THE ITEMS").trim());
            for (Map.Entry<String, String> values : maps.entrySet()) {
                if (!values.getKey().equalsIgnoreCase("NAME OF THE ITEMS")) {
                    b.selectWeight(values.getKey());
                     su.asserstEqualsvalues(values.getValue(),b.price.getText());
                    System.out.println("*********PASS********" + "Product = " + maps.get("NAME OF THE ITEMS") + "   " + values.getKey() + "  " + "Excel Value= " + values.getValue() + " ,UI value= " + b.price.getText());
                }
            }
            driver.navigate().back();
        }
    }
    @Test(dataProviderClass = SpiceMix.class, dataProvider = "Product-Rates")
    public void Spices(String a, ArrayList<HashMap<String, String>> ar) {
        driver = startBrowser(prop.getProperty("broswer"), prop.getProperty("base_url"));
        SeleniumUtils su = new SeleniumUtils();
        HomePage hp = new HomePage(driver);
        hp.closepopup();
        SpiceMix b = hp.spicespage();
        for (HashMap<String, String> maps : ar) {
            b.selectProduct(maps.get("Name of the Product").trim());
            for (Map.Entry<String, String> values : maps.entrySet()) {
                if (!values.getKey().equalsIgnoreCase("Name of the Product")) {
                    b.selectWeight(values.getKey());
                     su.asserstEqualsvalues(values.getValue(),b.price.getText());
                    System.out.println("*********PASS********" + "Product = " + maps.get("Name of the Product") + "   " + values.getKey() + "  " + "Excel Value= " + values.getValue() + " ,UI value= " + b.price.getText());
                }
            }
            driver.navigate().back();
        }
    }
}
