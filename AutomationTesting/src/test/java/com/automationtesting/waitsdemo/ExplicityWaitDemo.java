package com.automationtesting.waitsdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicityWaitDemo {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://letcode.in/waits");
		
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		
		Alert untill=wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(untill.getText());
		
		untill.accept();
		
		Thread.sleep(2000);
		
		driver.close();
		
		// How to switch to alert in seleneium
		
		/*
		 * Alert alert=driver.switchTo().alert();
		 * 
		 * alert.accept();
		 */
		
		// Above script will throw no such alert present exception
		
	}

}
