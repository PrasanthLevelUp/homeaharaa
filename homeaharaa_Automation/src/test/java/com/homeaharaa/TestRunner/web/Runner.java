package com.homeaharaa.TestRunner.web;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.pages.GroceriesPage;
import com.homeaharaa.pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Runner extends TestBase {

    @Test
    public void check(){
        driver=startBrowser(prop.getProperty("broswer"), prop.getProperty("base_url"));
        HomePage hp=new HomePage(driver);
        hp.closepopup();
        GroceriesPage b = hp.groceriespage();
        b.selectProduct("wheat");
        //b.getMinPrice("BARLEY");
       // b.getMaxPrice("ASAFOETIDA");
        b.getPriceBasedWeightAndQuantity("BARLEY","50g",2);
    }
}
