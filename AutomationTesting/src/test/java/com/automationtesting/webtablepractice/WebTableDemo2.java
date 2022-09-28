package com.automationtesting.webtablepractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo2 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://letcode.in/table");
		
		//My Req is to print rows count and verify that rows are equals to expected
		
		WebElement attendance = driver.findElement(By.id("simpletable"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();", attendance);
		
		List<WebElement> tablerows=driver.findElements(By.xpath("//table[@id='simpletable']//tr"));
		
		int rowcount = tablerows.size();
		
		System.out.println("Total Rows in table is ::"+rowcount);
		
		if(rowcount==4) {
			System.out.println("Pass");
		}
		else {
			System.out.println("False");
		}
		
		driver.close();
		
		
	}

}
