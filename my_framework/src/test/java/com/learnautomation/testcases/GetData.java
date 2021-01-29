package com.learnautomation.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetData {

	//@Test
	public void getData() {
		Response resp = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=28decb009b89249d94be9cc52749f324");
		int code = resp.getStatusCode();
		System.out.println(code);
	}
	
	//@Test
	public void test1() {
		RequestSpecification req = RestAssured.given();
		
		req.queryParam("Content-Type", "application/JSON");
		
		JSONObject json = new JSONObject();
		json.put("id","123");
		
		req.body(json.toString());
		
		Response ab = req.post("");
		
		ab.getStatusCode();
	}
	
	@Test
	public void restAuth() {
		RestAssured.given().auth().preemptive().basic("ToolsQA", "TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication/").then().assertThat().statusCode(200);
	}
	
	//@Test
	public void AuthenticationBasics()
	{
		
		RestAssured.authentication = RestAssured.preemptive().basic("", "");
		RestAssured.baseURI = "https://restapi.demoqa.com/authentication/CheckForAuthentication";
	 
		//RequestSpecification request = RestAssured.given();
	 
	 Response response = RestAssured.given().get();
	 System.out.println("Status code: " + response.getStatusCode());
	 System.out.println("Status message " + response.body().asString());
	}
	
	
}
