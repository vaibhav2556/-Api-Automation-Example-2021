package ApiAutomation.RestAssuredProject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class TC0007_CREATE {

	static String body;
	static Response resp;

	@Test
	public void create_User() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification specification = RestAssured.given();

		JSONObject object = new JSONObject();
		object.put("name", "morpheus");
		object.put("job", "leader");
		specification.header("Content-Type", "application/json");
		specification.body(object.toJSONString());

		resp = specification.request(Method.POST, "/api/users");

		body = resp.getBody().asString();

		System.out.println(body);

	}

	@Test
	void validate_ResposeBodywith_Id() {

		Assert.assertEquals(body.contains("id"), true, "Response Body doesnot contain Id");

	}

	@Test
	public void validated_responseBody_Name() {

		SoftAssert softassert = new SoftAssert();

		// Soft Assert
		softassert.assertEquals(body.contains("morpheus"), true, "Response Body doesnt contain name");

		softassert.assertAll();

		// Hard Assert
		// Assert.assertEquals(body.contains("morpheus"), true,"Response Body doesnt
		// contain name");

	}

	@Test
	void validate_respCode() {

		int code = resp.getStatusCode();
		System.out.println(code);
		
		 Assert.assertEquals(code,201);
		
		
		
	}

}
