package com.automationtesting.inheritancetestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScripts extends Base {

	@Test(dataProvider = "LoginData")
	public void OrangeHrmLogin(String usrname, String password) {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(usrname);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.cssSelector("button[class*=oxd]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Employee List']")).isDisplayed());

		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();

		driver.findElement(By.xpath("//li/a[text()='Logout']")).click();

	}

	@Test
	public void ninjaLogin() throws InterruptedException {

		driver.get("http://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li/a[text()='Login']")).click();
		
		Thread.sleep(2000);

		driver.findElement(By.id("input-email")).sendKeys("testingtraining@gmail.com");

		driver.findElement(By.id("input-password")).sendKeys("G@cloud2022");

		driver.findElement(By.cssSelector("input[class*=btn]")).click();

		String exp_url = "http://tutorialsninja.com/demo/index.php?route=account";

		String actual_url = driver.getCurrentUrl();

		Assert.assertEquals(exp_url, actual_url);// this script wil fail
	}

}
