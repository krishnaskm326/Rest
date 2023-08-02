package Practise;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RestGenericMethods.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CRUDOperations3 {

	//@BeforeTest
//	public void cofigure() {
//		baseURI = "http://rmgtestingserver";
//		port = 8084;
//	}
	@Test
	public void post() {

		JavaLibrary jlib=new JavaLibrary();
		HashMap jobj=new HashMap();
		jobj.put("createdBy", "krishna");
		jobj.put( "projectName", "osa"+jlib.random());
		jobj.put("status", "on going");
		jobj.put("teamSize", 5);
		
		Response resp = given().body(jobj).contentType(ContentType.JSON)
		.when().post("/addProject");
		String data = resp.jsonPath().get("projectId");
		resp.then().assertThat().log().all().statusCode(201).contentType(ContentType.JSON);
		
		given().pathParam("pId", data)
		.when().get("/projects/{pId}")
		.then().assertThat().log().all();

	}
	
	@Test
	public void auth() {
		
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("http://rmgtestingserver:8084/login")
		.then().log().all();
	}

}
