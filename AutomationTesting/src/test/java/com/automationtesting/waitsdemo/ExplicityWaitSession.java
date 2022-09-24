package com.automationtesting.waitsdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicityWaitSession {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://letcode.in/signin");

		WebElement username_txtbox = driver
				.findElement(By.xpath("(//input[@placeholder= 'Enter registered email'])[1]"));

		username_txtbox.sendKeys("testingtraining@gl.com");

		username_txtbox.clear();

		username_txtbox.sendKeys("testingtraining@gmail.com");

		WebElement password_txtbox = driver.findElement(By.xpath("//input[@type='password']"));

		password_txtbox.sendKeys("G@testing2022");

		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();

		WebElement toast = driver.findElement(By.xpath("//div[@role='alertdialog']"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOf(toast));
		
		System.out.println(toast.getText());

		wait.until(ExpectedConditions.invisibilityOf(toast));

		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

	}

}
