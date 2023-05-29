package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BDDGenericMethods.BaseClassAPI;
import BDDGenericMethods.EndPoints;
import BDDGenericMethods.IConstants;
import PojoClass.TYProject;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test3 extends BaseClassAPI{
@Test
public void test3() throws Throwable {
	
	String pName="OSA"+jlib.random();
	
	TYProject typ=new TYProject(pName, "krishna", "on going", 11);

	Response res=given().spec(reqest).body(typ).contentType(ContentType.JSON)
	.when().post(EndPoints.createProject);
	//.then().log().all();
	// validate using db
    String eData = res.jsonPath().get("projectId");
   	String query="select * from project";
	dlib.executeAndGetData(query,1,eData);
	
//delete project in gui
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
        driver.findElement(By.xpath("//td[text()='"+eData+"']/../descendant::td/a[@class=\"delete\"]")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        
        
}
}
