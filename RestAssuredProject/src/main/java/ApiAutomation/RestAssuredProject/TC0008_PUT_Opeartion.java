package ApiAutomation.RestAssuredProject;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class TC0008_PUT_Opeartion {

	static Response resp;
	static int code;
	static String line;

	@Test
	void update_Operation() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification specification = RestAssured.given();

		JSONObject object = new JSONObject();
		 object.put("id", "2");
		object.put("name", "vikas");
		object.put("job", "manual tester");

		specification.header("Content-Type", "application/json");
		specification.body(object.toJSONString());
		resp = specification.request(Method.PUT, "/api/users/2");

		String body = resp.getBody().asString();

		System.out.println("The Respose Body is :" + body);
		line = resp.getStatusLine();
		System.out.println(line);

		assertEquals(line, "HTTP/1.1 200 OK");

	}

	@Test
	int validate_resposeCode() {

		code = resp.getStatusCode();

		return code;

	}

	@Test

	void validate_Code() {
		assertEquals(validate_resposeCode(), 200);

		System.out.println(code);
	}

}
