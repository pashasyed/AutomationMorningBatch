package com.automationtesting.javascriptexecutorconcepts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeTest {

	static WebDriver driver; // Instance variables
	

	public static void takeScreenImage(String imgname) throws IOException {

		File source_location = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String project_location = System.getProperty("user.dir");
		File destination_location = new File(project_location + "\\ScreenShotLocation" + imgname + ".jpg");

		FileUtils.copyFile(source_location, destination_location);

	}

	public static void setUp() throws InterruptedException, IOException {

		// Upto launching of url we are writing code in this method
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/signin");

		Thread.sleep(2000);

		takeScreenImage("LaunchPage");

	}

	public static void login_LetCode_Application() throws InterruptedException, IOException {
		
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testingtraining@gmail.com");

		Thread.sleep(4000);

		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("G@testing2022");

		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();

		Thread.sleep(2000);

		takeScreenImage("HomePage");

	}

	public static void login_LetCode_Application_WithJS() throws InterruptedException, IOException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement username_textbox = driver.findElement(By.xpath("//input[@name='email']"));
		js.executeScript("arguments[0].value='testingtraining@gmail.com';", username_textbox);

		Thread.sleep(4000);

		WebElement password_textbox = driver.findElement(By.xpath("//input[@name='password']"));

		js.executeScript("arguments[0].value='G@testing2022';", password_textbox);

		Thread.sleep(4000);

		WebElement login_button = driver.findElement(By.xpath("//button[text()='LOGIN']"));
		js.executeScript("arguments[0].click();", login_button);

		Thread.sleep(2000);

		takeScreenImage("HomePage");
	}

	public static void verify_LetCode_Login() {

		String expected_url = driver.getCurrentUrl();
		String actual_url = "https://letcode.in/";

		if (expected_url.equals(actual_url)) {
			System.out.println("LetCode Sucessfuly logged in ");
		}

	}

	public static void logOut_LetCode() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement toast_message = driver.findElement(By.xpath("//div[@role='alertdialog']"));

		wait.until(ExpectedConditions.invisibilityOf(toast_message));

		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

		Thread.sleep(2000);

		takeScreenImage("LogoutPage");

	}

	public static void tearDown() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
		setUp();

		login_LetCode_Application();
		verify_LetCode_Login();
		;
		logOut_LetCode();
		tearDown();
	}

}
