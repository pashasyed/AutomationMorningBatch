package com.automationtesting.dropdownpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSession {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement fruitslist = driver.findElement(By.id("multiple-select-example"));

		Select fruits = new Select(fruitslist);

		if (fruits.isMultiple()) { // it will return true/false if it is multiselection drop-down  // True

			// true area will get execute
			fruits.selectByIndex(0);
			fruits.selectByIndex(2); // Now true area will get execute

		}
		else {
			// false area
			fruits.selectByIndex(1);
			
		}
	}

}
