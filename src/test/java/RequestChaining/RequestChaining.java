package RequestChaining;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import PojoClass.Employee;
import PojoClass.TYProject;
import RestGenericMethods.JavaLibrary;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChaining {


	@Test
	public void PostGetUpdateDeleteRequest() {
		JavaLibrary jlib=new JavaLibrary();
		TYProject emp=new TYProject("OSA"+jlib.random(), "krishna", "ON GOING", 5);
		baseURI="http://rmgtestingserver";
		port=8084;
		Response res= given()
				.body(emp).contentType(ContentType.JSON)
				.when().post("/addProject");

		// get data from response body
		String data = res.jsonPath().get("projectId");
		System.out.println(data);

		// provide input for another request gor get

		given().pathParam("pId",data).contentType(ContentType.JSON)
		.when().get("/projects/{pId}")
		.then().statusCode(200).contentType(ContentType.JSON).log().all()
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);

		//updated request

		JSONObject jobj=new JSONObject();

		jobj.put("createdBy", "krishnamoorthi");
		jobj.put("status", "completed");
		jobj.put("teamSize", 15);
		given().pathParam("pId",data).body(jobj).contentType(ContentType.JSON)
		.when().put("/projects/{pId}")
		.then().statusCode(200).contentType(ContentType.JSON).log().all()
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);

		// delete Request

		given().pathParam("pId",data).contentType(ContentType.JSON)
		.when().delete("/projects/{pId}")
		.then().statusCode(204).contentType(ContentType.JSON).log().all()
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
		System.out.println("deleted");
	}



}
