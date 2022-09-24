package com.automationtesting.dropdownpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		// WebElement carslist=driver.findElement(By.id("carselect"));

		Select select = new Select(driver.findElement(By.id("carselect")));

		List<WebElement> carslist = select.getOptions();
		
          //one after another  //3 cars
		for (WebElement car : carslist) { //1 //

			System.out.println(car.getText()); // BMW

		}
		
		select.selectByIndex(1);
		
		WebElement  selected_Car=select.getFirstSelectedOption();
		
		System.out.println("Selected car is ::"+selected_Car.getText());
		
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
