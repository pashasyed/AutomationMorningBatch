package com.automationtesting.dropdownpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// How to initialize empty browser

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement carslist = driver.findElement(By.id("carselect"));

		// Select class syntax

		Select select = new Select(carslist);

		// Note: Index always starts from 0

		//select.selectByIndex(2); // Honda
		
	        //or
		
		select.selectByVisibleText("Benz");

		Thread.sleep(5000);

		driver.close();

	}

}
