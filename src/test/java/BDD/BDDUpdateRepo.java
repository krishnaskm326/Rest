package BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BDDUpdateRepo {

	@Test
	public void updateRepo() {

		baseURI="http://rmgtestingserver";
		port=8084;
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "krishnamoorthi");
		jobj.put("status", "completed");
		
		given().body(jobj).contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_5207")
		.then().assertThat().statusCode(200).log().all();
	}
}
