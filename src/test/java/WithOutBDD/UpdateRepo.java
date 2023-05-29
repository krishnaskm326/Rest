package WithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateRepo {

	@Test
	public void updateRepo() {
		
		JSONObject jobj=new JSONObject();
		jobj.put("status","completed");
	RequestSpecification rspec=RestAssured.given();
	rspec.body(jobj);
	rspec.contentType(ContentType.JSON);
	Response response=rspec.put("http://rmgtestingserver:8084/projects/TY_PROJ_5086");
	
	System.out.println(response.statusCode());
	System.out.println(response.asString());
	System.out.println(response.contentType());
	System.out.println(response.prettyPrint());
}
}