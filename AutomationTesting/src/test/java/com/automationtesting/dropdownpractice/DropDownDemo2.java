package com.automationtesting.dropdownpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo2 {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		// Now I want to select value from dropdown based on value method.
		
		WebElement carslist =driver.findElement(By.id("carselect"));
		
		Select select= new Select(carslist);
		
		select.selectByValue("benz");
		
		// above code will select benz
		
		WebElement select_option=select.getFirstSelectedOption();
		
		System.out.println("Selected Option from dropdown is ::"+select_option.getText());
		// this statement will print exactly you selected from drop down
		
		
		Thread.sleep(2000);
		
		driver.close();
		
		}

}
