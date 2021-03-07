package ApiAutomation.RestAssuredProject;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class TC0006_ListOfResource {

	@Test
	void getListOf_Resource() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification specification = RestAssured.given();
		Response respo = specification.request(Method.GET, "/api/unknown");
		String body = respo.getBody().asString();

		System.out.println("ResponseBody :" + body);

		int code = respo.getStatusCode();
		System.out.println(code); // 404
		assertEquals(code, 200);

	}

	@Test
	void getListOf_Resource_Negative() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification specification = RestAssured.given();
		Response respo = specification.request(Method.GET, "/api/unknown/156");
		String body = respo.getBody().asString();

		System.out.println("ResponseBody :" + body);
		int code = respo.getStatusCode();
		System.out.println("getListOf_Resource_Negative :" + code);

		assertEquals(code, 404);

	}

}
