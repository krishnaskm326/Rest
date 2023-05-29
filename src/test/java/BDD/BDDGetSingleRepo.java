package BDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BDDGetSingleRepo {

	@Test
	public void getRepo() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects/TY_PROJ_5206")
		
		.then().assertThat().statusCode(200).log().all();
		
		
	}
}
