package Validation;


import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Practise.RakutenApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RakutenSerialization {

	@Test
	public void serialTest() throws Throwable, Throwable, IOException {
		
		Response resp = RestAssured.when().get("https://api.publicapis.org/entries");
		
		
		ObjectMapper map=new ObjectMapper();

		map.writeValue(new File("./rakutenapifile.json"),resp.then().log().all());

		ObjectMapper map1=new ObjectMapper();

		RakutenApi data = map1.readValue(new File("./src/test/resources/rakutenDataApi.json"), RakutenApi.class);

		

	}

}
