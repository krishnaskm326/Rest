package WithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRepo {

	@Test
	public void deleteRepo() {
		Response response=RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_5084");
		int code = response.statusCode();
		System.out.println(code);
	}
}
