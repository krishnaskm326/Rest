package Practise;

import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Validate {

	public void test() {
		
		baseURI = "http://rmgtestingserver";
		port = 8086;
		
		File f=new File(" ");
		Response responce = given().body(f).contentType(ContentType.JSON)
		.when().post("/addProject");
		String data = responce.jsonPath().get(DEFAULT_BODY_ROOT_PATH);
		
		
		
		given().pathParam(data, data)
		.when().get("/project")
		.then().assertThat().statusCode(DEFAULT_PORT).contentType(ContentType.JSON).log().all();
		
	}
}
