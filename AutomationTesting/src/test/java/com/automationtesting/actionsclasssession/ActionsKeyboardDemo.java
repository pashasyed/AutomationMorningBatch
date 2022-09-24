package com.automationtesting.actionsclasssession;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsKeyboardDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		  WebDriver driver= new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  
		  driver.manage().deleteAllCookies();
		  
		  driver.get("https://the-internet.herokuapp.com/key_presses");
		  
		  Actions action= new Actions(driver);
		  
		  action.sendKeys(Keys.ENTER).perform(); // This line will click on enter button in application
		  
		  WebElement entered_key=driver.findElement(By.xpath("//p[@id='result']"));
		  
		   String entered_buton=entered_key.getText();
		  
		  String expectedtext="You entered: SPACE";
		  
		  if(entered_buton.equals(expectedtext)) {
			  System.out.println("Successfully clicked on space button");
		  }
		  else {
			  System.out.println("Not clicked on space button");
		  }
		  
		 
		  
		  Thread.sleep(5000);
		  
		  driver.close();
	}

}
