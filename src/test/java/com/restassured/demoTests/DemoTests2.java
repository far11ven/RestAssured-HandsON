package com.restassured.demoTests;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.commonUtils.MyThreadLocal;
import com.restassured.utilities.FileOperations;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoTests2 {

	@Test
	public void MyThreadLocalDemo() {
		System.out.println("\n Running Demo Test1 (GET) ===="  + MyThreadLocal.get().readData("property1"));

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
		//String responseBody = response.getBody().asString();
		String responseBody = get("/Pune").asString();
		System.out.println("Response Body is =>  \n" + responseBody);

		//JSON Schema Matcher

		String schema = FileOperations.readFromFile("./src/test/res/weather-schema.json");
		
		System.out.println(schema);
		
		get("/Pune").then().assertThat()
		.body(matchesJsonSchema(schema))
		.body("City", equalTo("Pune"))
		.body("WeatherDescription", is(emptyArray()))
		.body("Temperature", is(nullValue()))
		.body("Humidity", is(arrayWithSize(2)));
	


	}

}
