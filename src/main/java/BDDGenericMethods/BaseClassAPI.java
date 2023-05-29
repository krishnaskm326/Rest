package BDDGenericMethods;

import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassAPI {
	
	public DataBaseUtility dlib=new DataBaseUtility();
	public JavaLibrary jlib=new JavaLibrary();
	public JSONUtility rLib=new JSONUtility();
	public RequestSpecification reqest;
	public ResponseSpecification respons;
	
	
	@BeforeSuite
	public void bfConnection() throws Throwable{
		dlib.connectDB();
		
		reqest=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		respons=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
	}
	
}
