package Practise;

import org.testng.annotations.Test;

import PojoClass.TYProject;
import RestGenericMethods.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Practise2 {

	@Test
	public void test1() {
		baseURI="http://rmgtestingserver:8084";
		port=8084;
		JavaLibrary jlib=new JavaLibrary();
		TYProject typ=new TYProject("OSA"+jlib.random(),"krishna","on going", 5);
		given().body(typ).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().log().all().statusCode(201).contentType(ContentType.JSON);
		}
	@Test
	public void test2() {
		baseURI="http://rmgtestingserver:8084";
		port=8084;
		when().get("/projects")
		.then().log().all();
}
	@Test
	public void test3() {
		baseURI="http://rmgtestingserver:8084";
		port=8084;
		when().get("/projects/TY_PROJ_6868")
		.then().log().all();
}
	
}
