package com.automationtesting.actionsclasssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		
		WebElement rightclick_btn = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		WebElement rightclick_option =driver.findElement(By.xpath("//span[text()='Quit']"));
		
		
		Actions action= new Actions(driver);
		
		action.moveToElement(rightclick_btn).contextClick().click(rightclick_option).perform();
		
        Alert alert	=	driver.switchTo().alert();
        
       String alert_message =  alert.getText();
       
       System.out.println(alert_message);
       
       alert.accept();
       
       Thread.sleep(2000);
       
       driver.close();
		
		
	}

}
