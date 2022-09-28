package com.automationtesting.webtablepractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://letcode.in/table");

		//My requirement is to print entire table data

		WebElement attendance = driver.findElement(By.id("simpletable"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();", attendance);
		
		List<WebElement> allrows=attendance.findElements(By.tagName("tr"));
		
		for(WebElement row:allrows) {
			String row_data=row.getText();
			System.out.println(row_data+"|| ");
		}
		
		driver.close();
	}
	

}
