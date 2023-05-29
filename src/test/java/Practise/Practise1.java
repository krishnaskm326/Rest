package Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClass.TYProject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Practise1 {
	@DataProvider
	public  Object[][] returnData() {
		Object[][] obj=new  Object[2][4];
		obj[0][0] = "osa43";
		obj[0][1] = "krishna";
		obj[0][2] = "on going";
		obj[0][3] = 22;
		
		obj[1][0] = "osa44";
		obj[1][1] = "krishna";
		obj[1][2] = "completed";
		obj[1][3] = 21;
		
		
		return obj;
		
	}
	@Test(dataProvider = "returnData")
	public void fetchData(String projectName,String createdBy,String status,int teamSize) {
		TYProject typ= new TYProject(projectName, createdBy, status, teamSize);
		baseURI = "http://rmgtestingserver";
		port=8084;
		given().body(typ).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().log().all();
		
		
	}

}
