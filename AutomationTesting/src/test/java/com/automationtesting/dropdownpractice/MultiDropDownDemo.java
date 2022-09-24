package com.automationtesting.dropdownpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiDropDownDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		WebElement mulitdropdown=driver.findElement(By.id("multiple-select-example"));
		
		Select fruits= new Select(mulitdropdown);
		
		fruits.selectByIndex(0); // This will select apple
		
		fruits.selectByValue("peach");
		
		List<WebElement> fruitslist=fruits.getAllSelectedOptions();
		
		for(WebElement fruit:fruitslist) {
			
			System.out.println(fruit.getText());// This is going to print all selected fruits in dropdown
		}
		
		Thread.sleep(2000); // thread.sleep will take millseconds as parameter
		
		fruits.deselectByValue("peach");
		
		Thread.sleep(2000); 
		
		fruits.deselectAll();
		
		Thread.sleep(2000); 
		
		driver.close();
			
	}

}
