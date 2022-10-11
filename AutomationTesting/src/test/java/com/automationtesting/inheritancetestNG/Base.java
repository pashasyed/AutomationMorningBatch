package com.automationtesting.inheritancetestNG;

import java.io.File;
import java.io.IOException;
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
import org.testng.internal.annotations.ITest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;

	@DataProvider(name = "LoginData")
	public Object[][] getUserData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "test";
		data[0][1] = "admin123";

		data[1][0] = "Admin";
		data[1][1] = "admin123";

		return data;
	}

	@BeforeTest
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void CaptureScreenShot(String imagename) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destination = new File("./ScreenImages" + imagename);

		FileUtils.copyFile(src, destination);
	}

	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			
			CaptureScreenShot(result.getMethod().getMethodName()+".jpg");
		}
		
		else if(result.getStatus()== ITestResult.SUCCESS) {
			System.out.println("TestCase "+result.getMethod().getMethodName()+" Pass");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
