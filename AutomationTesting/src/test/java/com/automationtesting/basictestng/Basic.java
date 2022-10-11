package com.automationtesting.basictestng;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic {

	public static WebDriver driver;
	public static String ScreenshotSubFolderName;

	public void captureImage(String image) throws IOException {
		if (ScreenshotSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			ScreenshotSubFolderName = myDateObj.format(myFormatObj);

		}

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desti = new File("./FailedScreenshots" + ScreenshotSubFolderName + "/" + image);
		FileUtils.copyFile(src, desti);
	}

	@DataProvider(name = "LoginData")
	public Object[][] getUserData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "admin";
		data[1][1] = "password123";
		

		data[2][0] = "admin";
		data[2][1] = "password123";

		return data;
	}

	@BeforeTest
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void failedScreenshot(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			captureImage(result.getMethod().getMethodName());
		}

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
