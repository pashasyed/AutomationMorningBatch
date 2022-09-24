package com.automationtesting.windowpractice;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleDemo2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://letcode.in/windows");

		String parent_window = driver.getWindowHandle();

		driver.findElement(By.xpath("//button[.='Muiltiple windows']")).click();
		
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String window :allwindows) {
			
			driver.switchTo().window(window);
			
			String currpage_title=driver.getCurrentUrl();
			
			String expted_title="https://letcode.in/alert";
			
			if(currpage_title.equals(expted_title)) {
				
				driver.findElement(By.xpath("//button[contains(text(),'Simple')]")).click();
				
				Alert alert=driver.switchTo().alert();
				
				System.out.println(alert.getText());
				
				alert.accept();
				break;
			}
		}
		
		driver.switchTo().window(parent_window);
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
	}

}
