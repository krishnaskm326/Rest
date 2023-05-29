package Practise;

import org.testng.annotations.Test;

import PojoClass.TYProject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Mocktest1 {

	@Test
public void postRequest() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Random ran=new Random();
		int random=ran.nextInt(5000);
		
		TYProject typ=new TYProject("TYP"+random, "krishna", "on going", 12);
		
		Response res =given().body(typ).contentType(ContentType.JSON)
		. when().post("/addProject");
		
		String result = res.jsonPath().get("projectId");
		//.then().assertThat().statusCode(201).log().all();
		
		
		
		// path
		
		given().pathParam("pId", result)
		.when().get("/projects/.{pId}")
		.then().assertThat().log().all();
	}
}
