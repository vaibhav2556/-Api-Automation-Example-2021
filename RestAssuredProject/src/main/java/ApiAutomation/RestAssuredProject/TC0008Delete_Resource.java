package ApiAutomation.RestAssuredProject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(common.listners.ResultListners.class)
public class TC0008Delete_Resource {
	static Response resp;
	
	@Test
	public void delete_Resource() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification specification = RestAssured.given();

		resp = specification.request(Method.DELETE, "/api/users/2");
		String body = resp.getBody().asString();
		System.out.println(body);

	}

	@Test
	void validate_status_Code()
	{
	
		int code=resp.getStatusCode();
		System.out.println(code);
		
		Assert.assertEquals(code, 204);
	}	
}
