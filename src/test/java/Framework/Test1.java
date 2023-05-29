package Framework;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BDDGenericMethods.BaseClassAPI;
import BDDGenericMethods.EndPoints;
import BDDGenericMethods.IConstants;
import BDDGenericMethods.JavaLibrary;
import PojoClass.TYProject;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 extends BaseClassAPI
{

	String ePId;
	@Test
	public void test1() throws Throwable {
		JavaLibrary jlib=new JavaLibrary();
		TYProject typ=new TYProject("OSA"+jlib.random(),"krishnas","on going", 12);
		
		//create project using api
		Response response=given().spec(reqest).body(typ).contentType(ContentType.JSON)
		.when().post(EndPoints.createProject);
		ePId=rLib.getJsonData(response, "projectId");
		System.out.println(ePId);
		
		// validate in database
		
		String query="select *from project";
		String aData = dlib.executeAndGetData(query, 1, ePId);
		if(ePId.equals(aData)) {
		System.out.println("valid data");
		
		}
		//validate in 
		WebDriver driver=null;
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		            driver.get(IConstants.appUrl);
		            driver.findElement(By.name("username")).sendKeys(IConstants.appUserName);
		            driver.findElement(By.name("password")).sendKeys(IConstants.appPassword);
		            driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		            driver.findElement(By.xpath("//ul/li/a[text()='Projects']")).click();
		            driver.findElement(By.xpath("//ul/li/a[text()='Projects']")).click();
		        List<WebElement> allPId = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		        boolean flag=false;
		        for( WebElement pIds:allPId) {
		        	
		        	if( pIds.equals(pIds)) {
		        		flag=true;
		        		break;}}
		        		if(flag==true) {
		        			System.out.println("data verified");
		        	}
		        		else {
		        			System.out.println("data in valid");
		        		}
		        }

		
		
		
	
}
