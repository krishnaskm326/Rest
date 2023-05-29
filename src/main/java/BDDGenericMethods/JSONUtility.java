package BDDGenericMethods;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class JSONUtility  {
	
	
	public String getJsonData(Response respons,String path) {
		
		String jsonData=respons.jsonPath().get(path);
		
		return jsonData;
	}
}
