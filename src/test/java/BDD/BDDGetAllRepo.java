package BDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BDDGetAllRepo {

	@Test
	public void getRepo() {

		baseURI="http://rmgtestingserver";
				port=8084;
				
				when().get("projects")
				
				.then().assertThat().statusCode(200)
				.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
				.contentType(ContentType.JSON).log().all();
	}
}
