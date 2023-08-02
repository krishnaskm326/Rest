package Practise;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import RestGenericMethods.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDOperation {

	@Test
	public void post() {
		
		JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "krishna");
		jobj.put("projectName", "OSA"+jlib.random());
		jobj.put("status", "on going");
		jobj.put("teamSize", 5);
		
		
		RequestSpecification rspec = RestAssured.given();
		
		rspec.body(jobj);
		rspec.contentType(ContentType.JSON);
		
		Response response = rspec.post("http://rmgtestingserver:8084/addProject");
		System.out.println(response.prettyPrint());
		
	}
	
	@Test
	public void update() {
		 
		JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "krishna");
		//jobj.put("projectName", "OSA"+jlib.random());
		jobj.put("status", "completed");
		jobj.put("teamSize", 5);
		
		
		RequestSpecification rspec = RestAssured.given();
		
		rspec.body(jobj);
		rspec.contentType(ContentType.JSON);
		
		Response response = rspec.put("http://rmgtestingserver:8084/projects/TY_PROJ_7513");
		System.out.println(response.prettyPrint());
		
	}
	@Test
	public void get() {
		
		
		
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_7512");
		int s_code=response.getStatusCode();
		System.out.println(s_code);
		
	}
	@Test
	public void delete() {
		
		
		
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_7512");
		int s_code=response.getStatusCode();
		System.out.println(s_code);
		
	}
}
