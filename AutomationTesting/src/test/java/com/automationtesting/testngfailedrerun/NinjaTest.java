package com.automationtesting.testngfailedrerun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NinjaTest {

	@Test(retryAnalyzer = IRetry.class)
	public void ninjaLogin() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();

		driver.findElement(By.xpath("//li/a[text()='Login']")).click();

		driver.findElement(By.id("input-email")).sendKeys("testingtraining@gmail.com");

		driver.findElement(By.id("input-password")).sendKeys("G@cloud2022");

		driver.findElement(By.cssSelector("input[class*=btn]")).click();

		String exp_url = "http://tutorialsninja.com/demo/index.php?route=account";

		String actual_url = driver.getCurrentUrl();

		Assert.assertEquals(exp_url, actual_url);// this script wil fail
	}

}
