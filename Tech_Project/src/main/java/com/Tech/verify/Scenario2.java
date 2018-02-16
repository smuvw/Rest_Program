package com.Tech.verify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Scenario2 {
	
		//method to input state
		public static String  inputstate(String State){
			String s= State;
			return s;
		}
	 
		@Test(priority=1)
		public static  void positiveScenario()
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
				System.out.println("Respone is correct " );
			}else
			{
				System.out.println("Respone is wrong " );
			}
			
						
		
		}
		
		
		
		@Test(priority=2)
		public static  void negativeSceanrio()
		{   
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI="http://services.groupkt.com/state/get/USA";
	 
			// Get the RequestSpecification of the request that you want to sent
			RequestSpecification httpRequest = RestAssured.given();
	 
			
	    //	input state name 	
			String state = inputstate("MM");
			
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
		
		
		}
	}


