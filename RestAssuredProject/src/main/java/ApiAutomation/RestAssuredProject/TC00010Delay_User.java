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
public class TC00010Delay_User {

	static Response resp;

	@Test
	void delay_User() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification specificaton = RestAssured.given();
		resp = specificaton.request(Method.GET, "/api/users?delay=3");
		String respBody = resp.getBody().asString();

		System.out.println("ResponseBody :" + respBody);

		/*
		 * assertEquals(code, 404); Assert.assertEquals(line, "HTTP/1.1 404 Not Found");
		 */
	}

	@Test
	public void validate_statusCode() {
		int code = resp.getStatusCode();

		System.out.println(code);
		Assert.assertEquals(code, 200);
	}

	@Test
	void validate_statuc_Line() {

		String line = resp.getStatusLine();
		System.out.println(line);
		Assert.assertEquals(line, "HTTP/1.1 200 OK");
		
	}

}
