package com.resrassured.demo;

import java.io.FileReader;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.resrassured.utilities.FileOperations;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoTests {

	/*@Test
	public void testingGETMethod() {

		System.out.println("Running Demo Test1 (GET) ====");

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Pune");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	}*/
	
	/*@Test
	public void testingPOSTMethod() {

		System.out.println("Running Demo Test2  (POST) ====");
		
		RestAssured.baseURI ="https://stage.beta.masterpassteststore.com/java/legacy-api/masterpass/transaction/postback";
		RequestSpecification httpRequest = RestAssured.given();
		
		String requestParams = FileOperations.readFromFile("./src/main/res/requestBody.json");
		System.out.println(requestParams);
	
		httpRequest.body(requestParams.toString());
		//Response response = httpRequest.request(Method.POST, "/POSTS");
		Response response = httpRequest.post("/POSTS");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		//String successCode = response.jsonPath().get("SuccessCode");
		//Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Correct Success code was returned");

	}*/
	
	@Test
	public void testingPOSTDEMOQAMethod() {

		System.out.println("Running Demo Test2  (POST) ====");
		
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification httpRequest = RestAssured.given();

		/*JSONObject requestParams = new JSONObject();
		
		requestParams.put("userId", 76818); // Cast
		requestParams.put("id", 76818);
		requestParams.put("title", "sdimpleuser2dd2011");
		requestParams.put("body", "password1");*/
		
		String requestParams = FileOperations.readFromFile("./src/main/res/requestBody1.json");
		
		System.out.println("Request Params :" + requestParams.toString());
		
		
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.request(Method.POST, "/POSTS");
		//Response response = httpRequest.post("/POSTS");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		//String successCode = response.jsonPath().get("SuccessCode");
		//Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Correct Success code was returned");

	}

	/*@Test
	public void testingPOSTDEMOQAMethod() {

		System.out.println("Running Demo Test2  (POST - demoqa) ====");

		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		request.body(requestParams.toString());
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}*/

	/*@Test
	public void testingPOSTMethod() {

		System.out.println("Running Demo Test1 (POST) ====");

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://stage.beta.masterpassteststore.com/java/legacy-api/masterpass/transaction/postback";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.POST, "/Hyderabad");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);


	}*/

}