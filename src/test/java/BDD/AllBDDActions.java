package BDD;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BDDGenericMethods.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class AllBDDActions {
	
	@BeforeMethod
	public void baseUrl() {
		baseURI="http://rmgtestingserver";
		port=8084;
	}
@Test
public void postRequest() {
	
	JavaLibrary jlib=new JavaLibrary();
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "krishna");
	jobj.put("projectName", "OSA"+jlib.random());
	jobj.put("status", "On Going");
	jobj.put("teamSize", 5);
	
	given().body(jobj).contentType(ContentType.JSON)
	.when().post("/addProject")
	.then().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).log().all()
	;
}

@Test
public void getSingleRequest() {
	when().get("/projects/TY_PROJ_5354")
	.then().statusCode(200).time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
}
@Test
public void getAllRequest() {
	when().get("/projects/TY_PROJ_5354")
	.then().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).log().all();
}
@Test
public void updateRequest() {
	
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "krishnamoorthi");
	
	jobj.put("status", "completed");
	jobj.put("teamSize", 10);
	
	given().body(jobj).contentType(ContentType.JSON)
	.when().put("/projects/TY_PROJ_5564")
	.then().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).log().all();
}
@Test
public void deleteRequest() {
	when().get("/projects/TY_PROJ_5354")
	.then().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).log().all();
}
}
