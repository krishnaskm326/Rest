package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.TYProject;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class Practise3 {

	@Test
	public void tes1() {
		baseURI="http://rmgtestingserver";
		port=8084;
		String eData="TY_PROJ_6871";
		Response res=when().get("/projects");
		boolean flag=false;
	   List<String> data=res.jsonPath().get("projectId");
	    
	    
	    
	    for(String pId:data) {
	    	//System.out.println(pId);
	    	if(pId.equalsIgnoreCase(eData)) {
	    		flag=true;
	    		System.out.println(pId);
	    	}
	    	
	    }
	   Assert.assertTrue(flag);
	   				}
}


