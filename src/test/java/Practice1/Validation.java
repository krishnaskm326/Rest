package Practice1;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.ProjectEcomm;
import RestGenericMethods.JavaLib;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Validation {

	@Test
	public void createResource() {
		
			JavaLib jlib=new JavaLib();
			ProjectEcomm pro=new ProjectEcomm("krishna","E-comm"+jlib.random(),"on going",4);
			
			 given().body(pro).contentType(ContentType.JSON)
			.when().post("http://rmgtestingserver:8084/addProject")
			
		    .then().assertThat().log().all().statusCode(201).contentType(ContentType.JSON);
	}
	@Test
	public void staticValidation() {
			String ExpData = "TY_PROJ_1288";
		Response response = when().get("http://rmgtestingserver:8084/projects");
		     String actData = response.jsonPath().get("[0].projectId");
		     System.out.println(actData);
		    Assert.assertEquals(actData, ExpData);
			//.then().assertThat().log().all().statusCode(200).contentType(ContentType.JSON);
			
	}
	@Test
	public void dynamicValidation() {
			String ExpData = "TY_PROJ_9087";
		Response response = when().get("http://rmgtestingserver:8084/projects");
		     List<String> actData = response.jsonPath().get("projectId");
		     boolean flag=false;
		     int count=0;
		     for(String pIds:actData) {
		    	 count++;
		    	 if(pIds.equals(ExpData)) {
		    		 flag=true;
		    	 }
		     }
		     System.out.println(count);
		       Assert.assertTrue(flag);
			 // response.then().log().all();
	}
}
