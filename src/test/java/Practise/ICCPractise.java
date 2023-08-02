package Practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCPractise {
	@Test
	
	public void iccTest() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.in");
		driver.findElement(By.name("q")).sendKeys("https://www.icc-cricket.com/"+Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='ICC Cricket']")).click();
	  	WebElement data = driver.findElement(By.xpath("//div/div/nav/ul/li/button[contains(text(),'Rankings')]"));
	  	Actions a=new Actions(driver);
		a.moveToElement(data).perform();
		driver.findElement(By.xpath("(//button[contains(text(),'Men')]/following-sibling::ul/li/a[contains(text(),'Overview')])[1]")).click();
		String cName = driver.findElement(By.xpath("(//div[text()='t20i']/ancestor::div//following-sibling::div[text()='India'])[1]")).getText();
		String ranking = driver.findElement(By.xpath("(//div[text()='t20i']/ancestor::div//following-sibling::div[text()='India'])[1]//preceding-sibling::div[contains(text(),'1')]")).getText();
		String points = driver.findElement(By.xpath("(//div[text()='t20i']/ancestor::div//following-sibling::div[text()='India'])[1]//following-sibling::div[contains(text(),'267')]")).getText();
		String format = driver.findElement(By.xpath("//div[text()='t20i']")).getText();
		System.out.println("countryName "+cName);
		System.out.println("countrypoints "+points);
		System.out.println("countryRanking "+ranking);
		System.out.println("type of format "+format);
		Assert.assertEquals(cName, "India");
		
		
		if(format.equalsIgnoreCase("t20i")) {
			if(cName.equalsIgnoreCase("India")) {
				if(ranking.equals("1")) {
					if(points.equals("267")) {
						System.out.println("TC pass");
					}
				}
			}
			
		}
	}
	
}
