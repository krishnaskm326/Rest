package BDD;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import RestGenericMethods.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BDDCreateRepo {

	@Test
	public void createRepo() {
		
	baseURI="http://rmgtestingserver";
	port=8084;
		
		JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "krishna");
		jobj.put("projectName", "OSA"+jlib.random());
		jobj.put("status", "onGoing");
		jobj.put("teamSize",5);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then().assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
		
		
		
		
	}
}
