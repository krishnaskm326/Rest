package Parameters;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import BDDGenericMethods.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Parameter {

	@Test
	public void getSingleRequestUsingPathParameter() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().pathParam("pId", "TY_PROJ_5622").contentType(ContentType.JSON)
		.when().get("/projects/{pId}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		       .time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).log().all();
		
	}
	@Test
	public void deleteRequestUsingPathParameter() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().pathParam("pId", "TY_PROJ_5624")
		.when().delete("/projects/{pId}")
		.then().assertThat().statusCode(204).contentType(ContentType.JSON)
		       .time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).log().all();
		
	}
	@Test
	public void UpdateRequestUsingPathParameter() {
		baseURI="http://rmgtestingserver";
		port=8084;
		JSONObject jobj=new JSONObject();		  //  fetch from json-simple dependency
		jobj.put("createdBy","krishnamoorthi");
		jobj.put("status", "completed");
		jobj.put("teamSize", 5);
		
		given().pathParam("pId", "TY_PROJ_5622").body(jobj).contentType(ContentType.JSON)
		.when().get("/projects/{pId}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		       .time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).log().all();
				
	}
	
	@Test
	public void queryParameter() {
		baseURI="https://reqres.in";
		
		given().queryParam("page", 2)
			   .contentType(ContentType.JSON)
		.when().get("/api/users?page")
		.then().assertThat().log().all().statusCode(200).contentType(ContentType.JSON)
		       .time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
		
			}
	
	
	@Test
	public void formParameter() {
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaLibrary jlib=new JavaLibrary();
		
		given()
		      .formParam("createdBy", "krishna")
		      .formParam("projectName", "OSA"+jlib.random())
		      .formParam("status", "on Going")
		      .formParam("teamSize", 10)		
		      .contentType(ContentType.JSON)
		.when().post("/addProject")
        .then().assertThat().log().all();
//    .time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
}
}