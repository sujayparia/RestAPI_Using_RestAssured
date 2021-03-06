package TestCase;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.getData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Test {

	@Test
	public void post() {

		// Define base url
		RestAssured.baseURI=getData.testData("TC002_PostTest", "BASE_URL");

		// Create request object
		RequestSpecification httpRequest = RestAssured.given();

		// Create payload 
		JSONObject obj = new JSONObject();
		obj.put("FirstName", "TestNamejay12");
		obj.put("LastName", "Lastnameparia12");
		obj.put("UserName", "Jayparia12");
		obj.put("Password", "123412");
		obj.put("Email", "abcparia12@gmail.com");
		
		// Add payload to request body
		httpRequest.body(obj.toString());
		
		// Add request header
		httpRequest.header("Content-Type","application/json");
		
		// Create response object
		Response httpResponse=null;
		if (getData.testData("TC002_PostTest", "METHOD").equalsIgnoreCase("GET")) {
			httpResponse = httpRequest.request(Method.GET);
		}
		else if (getData.testData("TC002_PostTest", "METHOD").equalsIgnoreCase("POST")) {
			httpResponse = httpRequest.request(Method.POST);
		}
		
		
		String responseStatus = httpResponse.getStatusLine();
		int responseCode = httpResponse.getStatusCode();
		String responseBody = httpResponse.getBody().asString();

		System.out.println("Response Status: --> "+responseStatus);
		System.out.println("Response Code: --> "+responseCode);
		System.out.println("Response Body: --> "+responseBody);
	}
	
}
