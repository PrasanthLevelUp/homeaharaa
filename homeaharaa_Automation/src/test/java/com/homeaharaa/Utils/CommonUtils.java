package com.homeaharaa.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	private static final int EMAIL_CHARS_LENGTH = 10;
	private static final String NADA_EMAIL_DOMAIN = "@getnada.com";

	private String email;

	private void generateEmailId() {
		this.email = RandomStringUtils.random(EMAIL_CHARS_LENGTH, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toLowerCase()
				.concat(NADA_EMAIL_DOMAIN);

		System.out.println(email);
	}

	public String generateName() {
		String name = RandomStringUtils.random(EMAIL_CHARS_LENGTH, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toLowerCase();
		return name;
	}

	public String generatePassword() {
		String name = RandomStringUtils.random(2, "QWERTYUIOPASDFGHJKLZXCVBNM")
				+ RandomStringUtils.random(2, "1234567890") + RandomStringUtils.random(2, "!@#$%")
				+ RandomStringUtils.random(3, "qwertyuiopasdfghjklmnbvcxz");
		return name;
	}

	public String getEmailId() {
		if (Objects.isNull(this.email)) {
			this.generateEmailId();
			this.createEmail();
		}
		return this.email;
	}

	public void createEmail() {
		RestAssured.baseURI = "https://getnada.com/api/v1/inboxes/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(email);
		System.out.println(response.asString());
	}

	public String priceValidation(String str) {
		String value = null;
		value = str.replace("(+$", "").replace(")", "");
		return value.trim();
	}

	public String addPrice(String Current, String NewPrice) {
		String value = null;
		value = Current.replace("(+$", "").replace(")", "");
		int a = Integer.parseInt(value);
		String sub = NewPrice.substring(0, NewPrice.length() - 3);
		int b = Integer.parseInt(sub);
		int AddedValue = a + b;
		return String.valueOf(AddedValue);
	}

	public String addPricecolor(String Current, String NewPrice) {
		int a = Integer.parseInt(Current);
		int b = Integer.parseInt(NewPrice);
		int AddedValue = a + b;
		return String.valueOf(AddedValue);
	}

	public String TotalpriceValidation(String actual) {
		String value = null;
		value = actual.replace("$", "").trim();
		return value;
	}

	public String TotalpriceValidation1(String actual) {
		String value = null;
		value = actual.replace("$", "").trim();
		String sub = value.substring(0, value.length() - 3);
		return sub;
	}

	public String speficationPrice(String actual) {
		String value = null;
		value = actual.replace("+$", "").trim();
		return value;
	}

	public String[] expiredate(String date) {
		String[] split = date.split("/");
		return split;
	}

	public String reducetotal(String totalprice, String data) {
		String sub = data.substring(0, data.length() - 3);
		int a = Integer.parseInt(totalprice);
		int b = Integer.parseInt(sub);
		int AddedValue = a - b;
		return String.valueOf(AddedValue);
	}

	public static HashMap<Object, Object> readjsondata(String file,String key,String itemname){
		JSONParser parser = new JSONParser();

		JSONArray a=null;
		try {
			a = (JSONArray) parser.parse(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		HashMap<Object, Object> pricelist = new HashMap<Object, Object>();

		for (Object o : a) {
			JSONObject item = (JSONObject) o;
			String name = (String) item.get(key);
			if(name.equalsIgnoreCase(itemname)) {
			for(Object s:item.keySet()) {
					pricelist.put(s, item.get(s));
			}
			System.out.println(pricelist);
			return pricelist;
			}
			// String name = (String) item.get(itemkey);
		}
		return pricelist;
	}
	
	public static double convertdo(String str) {
		//String str1 = str.replace('.', 's');
		//String[] arr = str1.split("s");
		//int val = Integer.parseInt(arr[0]);
		double num = Double.parseDouble(str);
		return convertto2decimal(num);
	}
	public static double convertdo2(String str) {
		String str1 = str.replace('.', 's');
		//String[] arr = str1.split("s");
		//String removechar = str1.replaceAll("[^\\d]", "").trim();
		String removechar = str1.replaceAll("[^\\w]", "").trim();
		String str2 = removechar.replace('s', '.');
		double num = Double.parseDouble(str2);
		return convertto2decimal(num);
	}
	
	public static double covertdoubl3(String str) {
		String str1 = str.replace("kg", "").trim();
		double num = Double.parseDouble(str1);
		return convertto2decimal(num);
	}
	
	public static double convertto2decimal(double a)
	{
	     DecimalFormat f = new DecimalFormat("##.00");
	     System.out.println(f.format(a));
	     return Double.parseDouble(f.format(a));
	}
	
	public static double roundToHalf(double x) {
	    return (double) (Math.ceil(x * 2) / 2);
	}
	
	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
	}


}
