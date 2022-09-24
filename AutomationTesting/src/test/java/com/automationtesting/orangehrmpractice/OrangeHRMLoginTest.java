package com.automationtesting.orangehrmpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://github.com/login");
		
		WebElement link=driver.findElement(By.partialLinkText("Forgot"));
		
		link.click();
		
		String expted_url= "https://github.com/password_reset";
		
		Thread.sleep(2000);
		
		String actual_url= driver.getCurrentUrl();// This will get url from the application
		
		if(actual_url.equals(expted_url)) {
			
			System.out.println("Successfully navigated to forgot password page");
		}
		
		
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
