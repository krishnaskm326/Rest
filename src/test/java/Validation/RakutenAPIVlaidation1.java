	
	package Validation;

	import static io.restassured.RestAssured.when;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.response.Response;

	public class RakutenAPIVlaidation1{

		@Test

		public void dynamicResponseValidation() throws Throwable {
			
			Response resp = when().get("https://api.publicapis.org/entries");
			resp.then().log().all();
			ArrayList< String> list =new ArrayList<String>();
			try
			{
				for(int i=1;i<14;i++) {
					String actData = resp.jsonPath().get("entries["+i+"].API");
					list.add(actData);
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			
			
			
			for(String api:list) {
			
			boolean flag=false;
			for(int i=1;i<14;i++) {
			String expData = resp.jsonPath().get("entries["+i+"].API");
		
				if(api.equalsIgnoreCase(expData)) {
					flag=true; 
				}
			}
			Assert.assertTrue(flag);
			System.out.println("data verified");
			resp.then().log().all();
		}

		}
	}


