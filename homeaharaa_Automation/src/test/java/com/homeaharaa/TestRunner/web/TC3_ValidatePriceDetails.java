package com.homeaharaa.TestRunner.web;

import java.util.HashMap;

import com.homeaharaa.Utils.CommonUtils;

public class TC3_ValidatePriceDetails {
	CommonUtils utils = new CommonUtils();
			
	public static void main(String[] args) {
		HashMap<Object, Object> itemdetails = CommonUtils.readjsondata(System.getProperty("user.dir")+"/src/main/resources/itempricedetailsjsonfiles/Snacks1.json",
				"NAME OF THE ITEMS","cashew pakoda");
		
		System.out.println(itemdetails.get("500 grams"));
	}

}
