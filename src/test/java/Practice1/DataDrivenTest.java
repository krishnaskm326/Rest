package Practice1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClass.TYProject;
import RestGenericMethods.ExcelUtility;
import RestGenericMethods.JavaLibrary;
import io.restassured.http.ContentType;

public class DataDrivenTest {
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
	public Object[][] getData() throws Throwable {
		
		ExcelUtility elib=new ExcelUtility();
		return elib.ReadSetOfData("Excel2");
		
	}
}
