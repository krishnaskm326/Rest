package Practice1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import PojoClass.ProjectEcomm;
import RestGenericMethods.JavaLib;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DiffWaysOfPostRequest {

	@Test
	public void createResourceWithHelpOfPojoClass() {
		JavaLib jlib=new JavaLib();
		ProjectEcomm pro=new ProjectEcomm("krishna","E-comm"+jlib.random(),"on going",4);
		
		given().body(pro).contentType(ContentType.JSON)
		.when().post("http://rmgtestingserver:8084/addProject")
		.then().log().all();
	}
	@Test
	public void createResourceWithHelpOfJsonObject() {
	JavaLib jlib=new JavaLib();
	JSONObject obj=new JSONObject();
	
	obj.put("createdBy", "krishna");
	obj.put("projectName", "E-comm"+jlib.random());
	obj.put("status", "on going");
	obj.put("teamSize", 4);
	
	given().body(obj).contentType(ContentType.JSON)
	.when().post("http://rmgtestingserver:8084/addProject")
	.then().log().all();
}
	@Test
	public void createResourceWithHelpOfHashMap() {
	JavaLib jlib=new JavaLib();
	HashMap obj=new HashMap();
	
	obj.put("createdBy", "krishna");
	obj.put("projectName", "E-comm"+jlib.random());
	obj.put("status", "on going");
	obj.put("teamSize", 4);
	
	given().body(obj).contentType(ContentType.JSON)
	.when().post("http://rmgtestingserver:8084/addProject")
	.then().log().all();
}
	
	@Test
	public void createResourceWithHelpOfJsonFile() {
		
		File f=new File("./src/test/resources/restData/JsonFile.json");
		given().body(f).contentType(ContentType.JSON)
		.when().post("http://rmgtestingserver:8084/addProject")
		.then().log().all();
		
	}
	
	
}
