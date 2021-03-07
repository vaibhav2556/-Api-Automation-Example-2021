package ApiAutomation.RestAssuredProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class TC0009RegisterUser {

	@Test
	void registerUser() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification specification = RestAssured.given();

		JSONObject obj = new JSONObject();
		obj.put("email", "eve.holt@reqres.in");
		obj.put("password", "pistol");
		specification.header("Content-Type", "application/json");

		specification.body(obj.toJSONString());

		Response resp = specification.request(Method.POST, "/api/register");

		String body = resp.getBody().asString();
		System.out.println("ResponseNody :" + body);
		int code = resp.getStatusCode();
		System.out.println(code);

	}

}
