package Practice1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import RestGenericMethods.JavaLib;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CRUDOperationsWithOutBdd {

	
	@Test
	public void createResource() {
		JavaLib jlib=new JavaLib();
		JSONObject obj=new JSONObject();
		
		obj.put("createdBy", "krishna");
		obj.put("projectName", "E-comm"+jlib.random());
		obj.put("status", "on going");
		obj.put("teamSize", 4);
		
		
		RequestSpecification rspec=RestAssured.given();
		rspec.body(obj);
		rspec.contentType(ContentType.JSON);
		Response response = rspec.when().post("http://rmgtestingserver:8084/addProject");
		System.out.println("content type :  "+response.contentType());
		System.out.println(" print 2 times : "+response.prettyPrint());
		//System.out.println(" print one time : "+response.prettyPeek());
		System.out.println(" response time : "+response.time());
		System.out.println(" status code : "+response.statusCode());
	}
	
	@Test
	public void getResource() {
		
		Response response=RestAssured.when().get("http://rmgtestingserver:8084/projects");
		System.out.println(response.prettyPeek());
	}
	@Test
	public void deleteResource() {
		Response response=RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_8902");
		System.out.println(response.prettyPeek());
	}
}
