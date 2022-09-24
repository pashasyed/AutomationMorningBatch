package com.automationtesting.alertspractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		String title=driver.getTitle();
		
		System.out.println("Page Title is ::"+title);
		
		String page_url =driver.getCurrentUrl();
		
		System.out.println("Paga Url is ::"+page_url);
		
		Thread.sleep(2000);
		
		WebElement textbox = driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));
		
		textbox.sendKeys("MR Training");
		
		Thread.sleep(2000);
		
		WebElement alert_button=driver.findElement(By.id("alertbtn"));
		
		alert_button.click();
			
		Alert alert=driver.switchTo().alert();
		
		String alert_message = alert.getText();
		
		System.out.println("Alert Message is ::"+alert_message);
		
		alert.accept();  // This method will click on 'OK' button in alert
		
		Thread.sleep(2000);
		
		
		driver.close();

	}

}
