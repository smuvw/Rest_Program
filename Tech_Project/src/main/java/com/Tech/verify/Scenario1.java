package com.Tech.verify;



import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response. Response;
import io.restassured.specification. RequestSpecification;
 
public class Scenario1 {
	
	//method to input state
	public static String  inputstate(String State){
		String s= State;
		return s;
	}
 
	@Test
	public static  void GetCityDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI="http://services.groupkt.com/state/get/USA";
 
		// Get the RequestSpecification of the request that you want to sent
		RequestSpecification httpRequest = RestAssured.given();
 
		
    //	input state name 	
		String state = inputstate("IL");
		
		// Make a request to the server by specifying the method Type and the method URL.
		//Response response = httpRequest.request(Method. GET, "/all");
		
		Response response = httpRequest.request(Method. GET, "/"+state.toUpperCase());
		
			
		//Check Status Code
		if(response.getStatusCode()== 200)
		{
			//Print Response
			String body = response.getBody().asString();
			System.out.println("########## ############################## ##########");
			System.out.println("Response Body => " + body);
		}else
		{
			System.out.println("Invalida State value " + state);
		}
		System.out.println();
		//Read Node Value

		
		String json = response.asString();		
		System.out.println("########## ############################## ##########");
		System.out.println("Largest City  - "  + _findValue(json,"largest_city" ));
		System.out.println();
		System.out.println("########## ############################## ##########");
		System.out.println("Capital - " + _findValue(json,"capital"));
		System.out.println();
	}
 
	
	private static String _findValue(String response,String required)
	{
		String values = response.split(required)[1];
		String returnValue = values.split(",")[0];
		return returnValue.replace("\"", "").replace(":", "").replace("}", "").trim();
		
	}
}
