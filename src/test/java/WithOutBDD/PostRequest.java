package WithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import BDDGenericMethods.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test
	public void createRepo() {
		
		JavaLibrary jlib=new JavaLibrary();        // Get random Number

		//STEP1: CREATE PRE-REQUISITES-REQUEST BODY
		JSONObject jobj=new JSONObject();		  //  fetch from json-simple dependency
		jobj.put("createdBy","krishna");
		jobj.put("projectName", "OSA"+jlib.random());
		jobj.put("status", "OnGoing");
		jobj.put("teamSize", 5);

		RequestSpecification rspec=RestAssured.given();
		
		
		rspec.body(jobj);
		rspec.contentType(ContentType.JSON);
		
		//STEP2: PERFORM ACTIONS
		Response response=rspec.post("http://rmgtestingserver:8084/addProject");
		
		//STEP3: VALIDATION
		System.out.println(response.prettyPrint()); // Print twice
		System.out.println(response.prettyPeek());  // Print once
		System.out.println(response.statusCode());  // Print Status code
		System.out.println(response.asString());    // Get body   
		System.out.println(response.contentType()); // print content type
		System.out.println(response.time());        // Print response time
		
	}
}

           /* as String   
            * {"msg":"Successfully Added",
            * "createdBy":"krishna","projectName":"OSA17",
            * "projectId":"TY_PROJ_5114","createdOn":"07/05/2023",
            * "status":"OnGoing"}   */

