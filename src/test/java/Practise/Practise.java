package Practise;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import BDDGenericMethods.JavaLibrary;
import PojoClass.TYProject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Practise {

	
	@Test
	public void postRequest() {
		JavaLibrary jlib=new JavaLibrary();
		
		TYProject typ=new TYProject("OSA"+jlib.random(),"krishna","on going", 5);
		RequestSpecification rspec=RestAssured.given();
		rspec.body(typ);
		rspec.contentType(ContentType.JSON);
		
		Response res=rspec.post("http://rmgtestingserver:8084/addProject");
		System.out.println(res.contentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		String data = res.jsonPath().get("projectId");
		System.out.println(data);
			}
	
	@Test
	public void getAllProject() {
		Response res = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_6868");
		res.then().log().all();
		 int aSCode = res.statusCode();
		Assert.assertEquals(200, aSCode);
			}
	@Test
	public void deleteProject() {
		Response res = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_6763");
		res.then().log().all();
	}
	@Test
	public void updateRepo() {
		
		TYProject typ=new TYProject(null, null, "completed", 4);
	RequestSpecification rspec=RestAssured.given();
	rspec.body(typ);
	rspec.contentType(ContentType.JSON);
	Response response=rspec.put("http://rmgtestingserver:8084/projects/TY_PROJ_6868");
	
	System.out.println(response.statusCode());
	System.out.println(response.asString());
	System.out.println(response.contentType());
	System.out.println(response.prettyPrint());
}
	}

