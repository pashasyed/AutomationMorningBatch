package com.automationtesting.testngconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {

	WebDriver driver;
	SoftAssert assertion= new SoftAssert();

	@BeforeTest
	public void setUP() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	public void url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	public void loginOrangeHRM() {
		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.cssSelector("button[class*=oxd-button]")).click();

		String actual = driver.getCurrentUrl();

		String expeted = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeL";

		assertion.assertEquals(actual, expeted);// If both are not equal then this test case will

		System.out.println("Logged In Successfully"); // In hard assertion if any line fail next line won't execute
		
		 // if we pass this line it will show results after continue
	}

	@Test(priority = 2)
	public void logoutOrangeHRM() {

		driver.findElement(By.cssSelector("p[class*=userdropdown]")).click();

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		WebElement loginlabel = driver.findElement(By.xpath("//h5"));

		assertion.assertTrue(loginlabel.isDisplayed());// if displayed return ture

		System.out.println("Logout Successfully");
		
		assertion.assertAll();
		
		
	}

	@AfterClass
	public void tearDown() {
		
		driver.close();
		
	}

}
