package RestGenericMethods;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class JSONUtility  {
	
	
	public String getJsonData(Response respons,String path) {
		
		String jsonData=respons.jsonPath().get(path);
		
		return jsonData;
	}
	
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable {
		TakesScreenshot	ts =(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;
	}
}
