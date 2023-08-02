package Practise;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RestGenericMethods.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashSet;

public class CRUDOperationBDD {

	@BeforeTest
	public void baseConfigure() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
	}
	@Test
	public void post() {

		JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "krishna");
		jobj.put("projectName", "OSA"+jlib.random());
		jobj.put("status", "on going");
		jobj.put("teamSize", 5);


		given().body(jobj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

	@Test
	public void get() {
		when().get("/projects/TY_PROJ_7514")
		.then().assertThat().statusCode(200).log().all();

	}

	@Test
	public void requestChain() {

		JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "krishna");
		jobj.put("projectName", "OSA"+jlib.random());
		jobj.put("status", "on going");
		jobj.put("teamSize", 5);


		Response resp = 	given().body(jobj).contentType(ContentType.JSON)
				.when().post("/addProject");
		String data = resp.jsonPath().get("projectId");
		System.out.println("data"+data);
		resp.then().log().all();


		given().pathParam("pID", data )
		.when().get("/projects/{pID}")
		.then().assertThat().log().all();

	}
	@Test
	public void jppractise() {
		String s = "this is fun show";
		String[] st = s.split(" ");
		String s1 = "fun tv show";
		String[] st1 = s1.split(" ");
		int k=0;
		String[] st2=new String[st.length+st1.length];
		
		for(int i=0;i<st2.length;i++) {
			if(i<st.length) {
				st2[i]=st[i];
			}			else {
				st2[i]=st1[k];
				k++;
			}		}
		
		LinkedHashSet<String> str=new LinkedHashSet<String>();

		for(int i=0;i<st2.length;i++) {
			str.add(st2[i]);				
					}
		
		for(String list:str) {				   //  this is fun show tv
			int count=0;
			for(int i=0;i<st2.length;i++) { 	//  this is fun show fun tv show
				if(list.equals(st2[i])) {
					count++;				
				}
				}
			if(count==1)
			 System.out.print(list+" ");
		}
		
		
	}
}


