package com.automationtesting.testngconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeTest {

	WebDriver driver;
	SoftAssert soft= new SoftAssert();

	@BeforeTest
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	public void url() {
		driver.get("https://letcode.in");

	}

	@BeforeMethod
	public void login() {
		
		List<WebElement> toastmesage=driver.findElements(By.xpath("//div[@role='alertdialog']"));
		
		if (toastmesage.size()>0) {
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@role='alertdialog']"))));
		}
		
	
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.name("email")).sendKeys("testingtraining@gmail.com");
		driver.findElement(By.name("password")).sendKeys("G@testing2022");

		driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	}

	@Test (priority = 2)
	public void courseContent() {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@role='alertdialog']"))));
		WebElement coursesMenu = driver.findElement(By.xpath("//a[text()='Courses']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", coursesMenu);
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://letcode.in/courses";

		soft.assertEquals(actual_url, expected_url);
	}

	@Test (priority = 1)
	public void productMenu() {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@role='alertdialog']"))));
		WebElement product_menu = driver.findElement(By.xpath("//a[text()='Product']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", product_menu);
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://letcode.in";

		soft.assertEquals(actual_url, expected_url);
	}

	@AfterMethod
	public void logOff() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

	}

	@AfterClass
	public void tearnDown() {
		soft.assertAll();
		driver.close();
	}

}
