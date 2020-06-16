package TestCase;

import org.testng.annotations.Test;

import com.utils.getData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Test {
	
	
	@Test
	public void get() {
		
		// Define base url
		RestAssured.baseURI=getData.testData("TC001_GetTest", "BASE_URL");
		
		// Create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Create response object
		Response httpResponse=null;
		if (getData.testData("TC001_GetTest", "METHOD").equalsIgnoreCase("GET")) {
			httpResponse = httpRequest.request(Method.GET);
		}
		else if (getData.testData("TC001_GetTest", "METHOD").equalsIgnoreCase("POST")) {
			httpResponse = httpRequest.request(Method.POST);
		}
		
		String temp = httpResponse.jsonPath().get("Temperature");
		
		System.out.println(temp);
		
		String responseStatus = httpResponse.getStatusLine();
		int responseCode = httpResponse.getStatusCode();
		String responseBody = httpResponse.getBody().asString();
		
		System.out.println("Response Status: --> "+responseStatus);
		System.out.println("Response Code: --> "+responseCode);
		System.out.println("Response Body: --> "+responseBody);
	}
}
