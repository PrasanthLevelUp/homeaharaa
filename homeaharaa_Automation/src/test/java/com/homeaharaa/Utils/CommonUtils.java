package com.homeaharaa.Utils;

import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;

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
}
