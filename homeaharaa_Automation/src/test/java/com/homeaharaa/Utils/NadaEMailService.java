package com.homeaharaa.Utils;

import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class NadaEMailService {

    private static final String INBOX_MESSAGE_KEY_NAME = "msgs";
    private static final String EMAIL_ID_ROUTE_PARAM = "email-id";
    private static final String MESSAGE_ID_ROUTE_PARAM = "message-id";
    private static final String NADA_EMAIL_INBOX_API = "https://getnada.com/api/v1/inboxes/{email-id}";
    private static final String NADA_EMAIL_MESSAGE_API = "https://getnada.com/api/v1/messages/{message-id}";

private static String messageID;
    
    public void getEmailID(String email) {
    	 RestAssured.baseURI = "https://getnada.com/api/v1/inboxes/";
    	 RequestSpecification httpRequest = RestAssured.given();
    	 Response response = httpRequest.get(email);
    	 System.out.println(response.asString());
    	 JsonPath jsonPathEvaluator = response.jsonPath();
    	 messageID = jsonPathEvaluator.getString("msgs.uid").replace("[", "").replace("]", "");
    	 System.out.println("Message ID "+messageID);
    }
    
    public String getOTP(String Email) {
    	this.getEmailID(Email);
    	 RestAssured.baseURI = "https://getnada.com/api/v1/messages/html/";
    	 RequestSpecification httpRequest = RestAssured.given();
    	 Response response = httpRequest.get(messageID);
    	 ResponseBody body = response.getBody();
    	 System.out.println(body.asString());
    	 String strbody = body.asString();
    	 String[] str = strbody.split("<b>");
    	 String stropt = str[1].substring(0, 6);
    	 System.out.println(stropt);
    	 return stropt;
    }

}
