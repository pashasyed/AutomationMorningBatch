package com.automationtesting.orangehrmpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubDemoTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://github.com/login");

		WebElement usrname_txtbox = driver.findElement(By.id("login_field"));

		usrname_txtbox.sendKeys("MRTraining@gmail.com");
		
		Thread.sleep(2000);

		usrname_txtbox.clear();

		usrname_txtbox.sendKeys("JSNTraining@gmail.com");

		WebElement password_txtbox = driver.findElement(By.id("password"));

		password_txtbox.sendKeys("Testing@123");

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
