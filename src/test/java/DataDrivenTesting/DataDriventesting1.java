package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClass.TYProject;
import RestGenericMethods.JavaLibrary;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;


public class DataDriventesting1 {

	@Test(dataProvider = "getData")
	public void ReciveData(String projectName,String createdBy,String Status,int teamSize) {
		JavaLibrary jlib=new  JavaLibrary();
		TYProject typ=new TYProject(projectName+jlib.random(), createdBy, Status, teamSize) ;
			baseURI="http://rmgtestingserver";
			port=8084;
		given().body(typ).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().statusCode(201).log().all();
			
		}
	@DataProvider
	public Object[][] getData(){
		
		Object obj[][]=new Object[4][4];
		
		obj[0][0]="OSA";
		obj[0][1]="krishna1";
		obj[0][2]="completed";
		obj[0][3]=5;
		
		obj[1][0]="OSA";
		obj[1][1]="krishna2";
		obj[1][2]="On Going";
		obj[1][3]=6;
		
		obj[2][0]="OSA";
		obj[2][1]="krishna3";
		obj[2][2]="On going";
		obj[2][3]=7;
		
		obj[3][0]="OSA";
		obj[3][1]="krishna4";
		obj[3][2]="up coming";
		obj[3][3]=8;
		
		return obj;
		
	}
	
}
