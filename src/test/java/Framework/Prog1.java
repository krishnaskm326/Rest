package Framework;

import java.util.LinkedHashSet;
import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prog1 { 

	@Test
	public void test() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter 5 numbers");
		LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
		for(int i=0;i<5;i++) {
			int num=sc.nextInt();
			if(set.add(num)==false) {
				set.remove(num);
			}
			else {
				set.add(num);
			}
		}
		System.out.println(set);
	}
	
	
	
	
	@Test
	public void test1() {
		
		try {
			System.out.println(10/0);
		}
        catch(ArithmeticException a) {
			
		}
		catch(Exception e) {
			
		}
		
	}
	@Test
	public void test2() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	}
}
