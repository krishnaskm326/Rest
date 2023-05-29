package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BDDGenericMethods.BaseClassAPI;
import BDDGenericMethods.EndPoints;
import BDDGenericMethods.IConstants;
import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test2 extends BaseClassAPI{
	@Test
	public void test2() throws Throwable {
		
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
            driver.findElement(By.xpath("//button/span")).click();
            
            String pName="OSA"+jlib.random();
            System.out.println(pName);
            driver.findElement(By.name("projectName")).sendKeys(pName);
         //   driver.findElement(By.name("teamSize")).sendKeys("10");
            driver.findElement(By.name("createdBy")).sendKeys("krishnamoorthi");
            WebElement element = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
            Select s=new Select(element);
            s.selectByValue("On Going");
            driver.findElement(By.xpath("//input[@type=\"submit\"]")).submit();
	
	 String pId = driver.findElement(By.xpath("//td[text()='"+pName+"']/../td[1]")).getText();
	 System.out.println(pId);
		
	 String query="select * from project";
	 
	 dlib.executeAndGetData(query, 1, pId);
	 
	 given().spec(reqest).contentType(ContentType.JSON)
	 .when().get(EndPoints.getSingleProject+pId)
	 .then().log().all();
		
	}

}
