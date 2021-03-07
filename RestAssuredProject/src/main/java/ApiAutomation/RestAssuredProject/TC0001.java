package ApiAutomation.RestAssuredProject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class TC0001 {
	static Response response;

	@Test
	void getWeatherDeatils() {
		RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
		RequestSpecification specification = RestAssured.given();
		response = specification.request(Method.GET, "/Pune");

		String respBody = response.getBody().asString();

		System.out.println("ResponseBody :" + respBody);

	}

	@Test
	void validateStatusCode() {

		int code = response.statusCode();
		System.out.println(code);

		Assert.assertEquals(code, 200);

	}

	@Test
	void validateStatusLine() {

		String line = response.statusLine();
		System.out.println(line);

		Assert.assertEquals(line, "HTTP/1.1 200 OK");

	}

}
