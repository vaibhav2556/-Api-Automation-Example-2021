package ApiAutomation.RestAssuredProject;

import org.junit.Assert;
import org.omg.CORBA.RepositoryIdHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class Tc0004 {

	@Test
	void getSingleUser() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();

		Response response = request.request(Method.GET, "/api/users/2");

		String body = response.getBody().asString();

		System.out.println("ResponsBody :"+body);

		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(statusCode);
		
		
		
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		
		String type=response.header("Content-type");
		System.out.println(type);
		
		Assert.assertEquals("Content-Type not Matched", "application/json; charset=utf-8",type );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
