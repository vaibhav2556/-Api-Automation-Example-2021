package ApiAutomation.RestAssuredProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class Tc0005_SingleUserNotFound {

	@Test
	public void SingleUserNotFound() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification specificaton = RestAssured.given();
		Response resp = specificaton.request(Method.GET, "/api/users/23");
		String respBody = resp.getBody().asString();

		System.out.println("ResponseBody :" + respBody);

		int code = resp.getStatusCode();
		String line = resp.getStatusLine();
		System.out.println(code);

		System.out.println(line);

		assertEquals(code, 404);
		Assert.assertEquals(line, "HTTP/1.1 404 Not Found");
		

	}

}
