package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class SSCreate {

	@Test
	public void create() {
		JSONObject jobj=new JSONObject();
		jobj.put("city", "salem");
		jobj.put("country", "india");
		jobj.put("email", "krishnaskm1@gmail.com");
		jobj.put("firstName", "krishna");
		jobj.put("gender", "male");
		jobj.put("lastName", "skm");
		jobj.put("password", "Krishna@1");
		jobj.put( "phone", 750331228);
		jobj.put("state", "karnataka");
		jobj.put( "zoneId", "2");
		//jobj.put(jobj, jobj);
	
			baseURI="https://www.shoppersstack.com/shopping/";
			
			
			
		//	File f=new File("C:\\Users\\aarathana\\Desktop\\ss.json");
           	given().auth().basic("admin", "admin").body(jobj).contentType(ContentType.JSON)
			.when().post("/shoppers")
			.then().log().all();
	
	}
	@Test
	public void get() {
			baseURI="https://www.shoppersstack.com/shopping/";
			String id = "integer($int32)";
			given().pathParam("shopperId", id)
			.when().post("shoppers/{shopperId}/address")
			.then().log().all();
	
	}
}
