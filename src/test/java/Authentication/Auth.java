package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth {

	@Test
	public void basicAuth() {
		baseURI="http://rmgtestingserver";
		port=8084;
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	
	@Test
	public void digestAuth() {
		baseURI="http://rmgtestingserver";
		port=8084;
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	
	@Test
	public void authPreemptive() {
		baseURI="http://rmgtestingserver";
		port=8084;
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
		
	}
	
	
	@Test
	public void bearerToken() {
		baseURI="https://api.github.com";
		JSONObject jobj=new JSONObject();
		jobj.put("name", "krishna56");
		
		given().auth().oauth2("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")
		 	   .body(jobj).contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().statusCode(201).log().all();
		
	}
	
	@Test
	public void auth2Coops(){
	
		
		 Response res=given()
				.formParam("client_id", "OSA-1.0")
				.formParam("client_secret", "5ab6c788dd517e4363b885cfff0bc9fc")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://osa.com")
				.formParam("code", "authorization_code")
		.when().post("http://coop.apps.symfonycasts.com/token");
		 res.then().log().all();
		// capture the token from the response
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		
		
		// create another request and use the token to access the APIS
		given().auth().oauth2(token).pathParam("USER_ID",4508)
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then().log().all();
	

	given().auth().oauth2(token).pathParam("USER_ID",4508)
			.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
			.then().log().all();
	
	given().auth().oauth2(token).pathParam("USER_ID",4508)
	.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	.then().log().all();
	
	given().auth().oauth2(token).pathParam("USER_ID",4508)
	.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
	.then().log().all();
	
	given().auth().oauth2(token).pathParam("USER_ID",4508)
	.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
	.then().log().all();
}
}
