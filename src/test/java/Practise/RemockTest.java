package Practise;

import org.testng.annotations.Test;

import PojoClass.TYProject;
import RestGenericMethods.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RemockTest {
	@Test
	public void reqChain() {
		baseURI="http://rmgtestingserver";
		port=8084;

		JavaLibrary jlib=new JavaLibrary();
		String p_Name="TYP"+jlib.random();
		TYProject typ=new TYProject(p_Name, "krishna", "on going", 12);
		Response res= given().body(typ).contentType(ContentType.JSON)
				.when().post("/addProject");
		//.then().log().all();
		String data=res.jsonPath().get("projectId");

		given().pathParam("pId", data)
		.when().get("/projects/{pId}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();

	}

}
