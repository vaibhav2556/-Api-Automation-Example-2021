package ApiAutomation.RestAssuredProject;

import static org.testng.Assert.assertEquals;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Listeners(common.listners.ResultListners.class)
public class TC0003 {

	@Test
	void getListOfEmployee() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification response = RestAssured.given();

		Response body = response.request(Method.GET, "/api/users?page=2");

		String responseBody = body.getBody().asString();
		System.out.println(responseBody);
		
		int code=body.getStatusCode();
		
		System.out.println(code);
		
	Assert.assertEquals(code, 200);

	

	}

}
