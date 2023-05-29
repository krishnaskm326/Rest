package WithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjects {
	@Test
	public void getSingleRepo() {
		Response res=RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_5096");
		//res.then().log().all();
		int code=res.statusCode();
		//Assert.assertEquals(200, code);
		System.out.println(code);
		System.out.println(res.prettyPeek());
	}
}
