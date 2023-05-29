package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

import BDDGenericMethods.JavaLibrary;
import PojoClass.TYProject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class Test1Validation {

	@Test
	public void test1() {

		baseURI="http://rmgtestingserver";
		port=8084;
		String expData = "TY_PROJ_5993";
		Response res=when().get("/projects");
		List<String> data = res.jsonPath().get("projectId");
		Boolean flag=false;
		for(String pId:data) {
		System.out.println(pId);
		if(pId.equalsIgnoreCase(expData)) {
			flag=true;
		}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		res.then().statusCode(200).log().all();
	}
	
	
	
	@Test
	public void test2() {
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaLibrary jlib=new JavaLibrary();
		TYProject typ=new TYProject(DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH, DEFAULT_PORT);
		
	}
}
