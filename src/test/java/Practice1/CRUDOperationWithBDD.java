package Practice1;

import org.testng.annotations.Test;

import PojoClass.ProjectEcomm;
import RestGenericMethods.JavaLib;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CRUDOperationWithBDD {

	@Test
	public void createResource() {
		
			JavaLib jlib=new JavaLib();
			ProjectEcomm pro=new ProjectEcomm("krishna","E-comm"+jlib.random(),"on going",4);
			
			given().body(pro).contentType(ContentType.JSON)
			.when().post("http://rmgtestingserver:8084/addProject")
			.then().assertThat().log().all().statusCode(201).contentType(ContentType.JSON);
			
	}
	
	@Test
	public void getResource() {
		
			
			when().get("http://rmgtestingserver:8084/projects/TY_PROJ_8998")
			.then().assertThat().log().all().statusCode(200).contentType(ContentType.JSON);
	}
	
	@Test
	public void deleteResource() {
		
			
			when().delete("http://rmgtestingserver:8084/projects/TY_PROJ_8999")
			.then().assertThat().log().all().statusCode(204).contentType(ContentType.JSON);
	}
	
}
