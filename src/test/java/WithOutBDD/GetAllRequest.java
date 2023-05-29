package WithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetAllRequest {
@Test
public void getRepo() {
	Response res=RestAssured.get("http://rmgtestingserver:8084/projects");
	res.then().log().all();
	int code=res.statusCode();
	Assert.assertEquals(200, code);
	System.out.println(code);
}
}
