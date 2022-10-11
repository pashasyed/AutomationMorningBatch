package com.automationtesting.basictestng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScripts extends Basic {
	
	String actual;
	
	String expected;
	
	SoftAssert assertion= new SoftAssert();
	
	@Test(dataProvider = "LoginData", retryAnalyzer = IRetry.class)
	public void loginOrangeHRM(String username, String password) throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys(username);

		Thread.sleep(3000);

		driver.findElement(By.name("password")).sendKeys(password);

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("button[class*=oxd-button]")).click();

		expected = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

		actual = driver.getCurrentUrl();

		assertion.assertEquals(expected, actual);

		System.out.println("Login Successfully");
		
		assertion.assertAll();
		
		Thread.sleep(3000);

		if (expected.equals(actual)) {
			driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		}

	}


}
