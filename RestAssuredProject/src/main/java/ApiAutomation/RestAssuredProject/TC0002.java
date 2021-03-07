package ApiAutomation.RestAssuredProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Listeners(common.listners.ResultListners.class)
public class TC0002 {

	@Test(enabled=false)
	void verifyJsonData() {

		RestAssured.baseURI ="https://restapi.demoqa.com/customer";

		RequestSpecification specification = RestAssured.given();

		JSONObject object = new JSONObject();
		object.put("FirstName", "vaibhav");
		object.put("LastName", "Shrirao");
		object.put("UserName", "vaibhav123");
		object.put("Password", "v001");
		object.put("FirstName", "vaibhav@gmail.com");

		specification.header("Content-Type", "application/json");
		specification.body(object.toJSONString());

		Response respBody = specification.request(Method.POST ,"/register");

		String resp = respBody.getBody().asString();
		System.out.println(resp);

		
			}

}
