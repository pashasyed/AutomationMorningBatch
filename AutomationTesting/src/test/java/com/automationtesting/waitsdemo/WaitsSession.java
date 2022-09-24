package com.automationtesting.waitsdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsSession {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		
		// //button[@id='btn2'] --> basic xpath syntax approach 
		
		 //button[text()='Add Textbox2'] --> text method approach in xpath
		
		driver.findElement(By.xpath("//button[text()='Add Textbox2']")).click();
		
		driver.findElement(By.xpath("(//h3/input[@placeholder='Textbox2'])[1]")).sendKeys("MR Training");
		
		
		
		// Above script will fail due to element loading issue, above ele will be displayed after 10 sec,
		// but selenuium  or driver won't wait for 10 sec for any element.
		// This will throw no such element exception
		Thread.sleep(2000);// This will just stop execution for view.
		
		driver.close();
	}

}
