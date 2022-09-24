package com.automationtesting.orangehrmpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://github.com/login");
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Forgot password?")).click();
		
		Thread.sleep(2000);
		
		String expected_url= "https://github.com/password_reset";
		
		  String actual_url=driver.getCurrentUrl();
		  
		  if(expected_url.equals(actual_url)) {
			  System.out.println("Successfully moved to forgot password page");
		  }
		
		driver.close();
	}

}
