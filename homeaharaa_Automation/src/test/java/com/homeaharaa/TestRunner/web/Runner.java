package com.homeaharaa.TestRunner.web;

import com.homeaharaa.TestBase.TestBase;
import com.homeaharaa.pages.GroceriesPage;
import org.testng.annotations.Test;

public class Runner extends TestBase {
    @Test
    public void check(){
        driver=startBrowser(prop.getProperty("broswer"), prop.getProperty("base_url"));
        System.out.println("tests");
        GroceriesPage b= new GroceriesPage(driver);
        //b.selectProduct("BARLEY");
        //b.getMinPrice("BARLEY");
       // b.getMaxPrice("ASAFOETIDA");
        b.getPriceBasedWeightAndQuantity("BARLEY","50g",2);
    }
}
