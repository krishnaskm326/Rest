package Validation;


import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Validations {
	@BeforeMethod
	public void bm() {
		baseURI="http://rmgtestingserver";
		port=8084;
	}
	
	@Test
	public void staticResponseValidation() {

		String expData = "TY_PROJ_3638";

		Response resp = when().get("/projects");

		String actData = resp.jsonPath().get("[2].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verified");
		resp.then().log().all();
	}

	
	@Test
	
	public void dynamicResponseValidation() {
		String expData = "TY_PROJ_5748";
		Response resp = when().get("/projects");

		boolean flag=false;
		List<String>actData = resp.jsonPath().get("projectId");
		for(String pId:actData) {
			if(pId.equalsIgnoreCase(expData)) {
				flag=true; 
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		resp.then().log().all();
	}
}
