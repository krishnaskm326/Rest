package Practice1;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;

import PojoClass.ProjectEcomm;
import RestGenericMethods.JavaLib;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RequestChain {

	@Test
	public void createResource() {
		
			JavaLib jlib=new JavaLib();
			ProjectEcomm pro=new ProjectEcomm("krishna","E-comm"+jlib.random(),"on going",4);
			
			Response response = given().body(pro).contentType(ContentType.JSON)
			.when().post("http://rmgtestingserver:8084/addProject");
			String pId = response.jsonPath().getJsonObject("projectId");
		//	.then().assertThat().log().all().statusCode(201).contentType(ContentType.JSON);
			
			
			given().pathParam("Pid", pId)
			.when().get("http://rmgtestingserver:8084/projects/{Pid}")
			.then().assertThat().log().all().statusCode(200).contentType(ContentType.JSON);
			
	}
}
