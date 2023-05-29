package DiffWaysOfPostRequest;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import BDDGenericMethods.JavaLibrary;

import PojoClass.TYProject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PostRequestInDiffWays {
@Test
public void postRequestUsingPojo() {
		
	baseURI="http://rmgtestingserver";
	port=8084;
	JavaLibrary jlib=new JavaLibrary();
	TYProject typ=new TYProject("OSA"+jlib.random(), "krishna", "ON GOING", 5);
	
	given().body(typ).contentType(ContentType.JSON)
	.when().post("/addProject")
	.then().assertThat().statusCode(201)
	.contentType(ContentType.JSON).log().all()
	.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
}

@Test
public void postRequestJsonObject() {
	baseURI="http://rmgtestingserver";
	port=8084;
	JavaLibrary jlib=new JavaLibrary();
	JSONObject jobj=new JSONObject();
	jobj.put("projectName", "OSA"+jlib.random());
	jobj.put("createdBy", "krishna");
	jobj.put("status", "on going");
	jobj.put("teamSize", 5);
	
	given().body(jobj).contentType(ContentType.JSON)
	
	.when().post("/addProject")
	
	.then().assertThat().statusCode(201).contentType(ContentType.JSON)
	.log().all().time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
}
@Test
public void postRequestUsingFile() {
	baseURI="http://rmgtestingserver";
	port=8084;
	File f=new File("./src/test/resources/restData/JsonFile.json");
	given().body(f).contentType(ContentType.JSON)
	.when().post("/addProject")
	.then().assertThat().statusCode(201).contentType(ContentType.JSON)
	.log().all().time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
}
@Test
public void postRequestUsingMap() {
	baseURI="http://rmgtestingserver";
	port=8084;
	HashMap<Object, Object> map=new HashMap<Object, Object>();
	JavaLibrary jlib=new JavaLibrary();
	
	map.put("projectName", "OSA"+jlib.random());
	map.put("createdBy", "krishna");
	map.put("status", "on going");
	map.put("teamSize", 5);
	
	given().body(map).contentType(ContentType.JSON)
	.when().post("/addProject")
	.then().assertThat().statusCode(201).contentType(ContentType.JSON)
	.log().all().time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
}

}
