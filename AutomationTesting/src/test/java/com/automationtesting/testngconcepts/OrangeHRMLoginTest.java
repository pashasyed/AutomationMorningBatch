package com.automationtesting.testngconcepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {

	WebDriver driver;
	
	SoftAssert assertion= new SoftAssert();

	String expected;
	String actual;

	@DataProvider(name = "LoginData")
	public Object[][] getUserData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "test";
		data[0][1] = "admin123";

		data[1][0] = "admin";
		data[1][1] = "password123";

		data[2][0] = "Admin";
		data[2][1] = "admin123";

		return data;
	}

	@DataProvider(name = "LoginData")
	public Object[][] getExcelData() throws IOException {

		File f = new File("C:\\Users\\gurum\\Desktop\\TestData.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook book = WorkbookFactory.create(fi);

		Sheet sh = book.getSheet("LoginData");

		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

		for (int i = 0; i < sh.getLastRowNum(); i++) { // for rows 1 row

			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) { // 1 row with all cells

				data[i][j] = sh.getRow(i + 1).getCell(j).toString();

			}
		}
		return data;
	}

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
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(dataProvider = "ExcelData")
	public void loginOrangeHRM(String username, String password) throws InterruptedException {

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

	}

	@AfterMethod
	public void logOff() throws InterruptedException {

		Thread.sleep(3000);

		if (expected.equals(actual)) {
			driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		}

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	
	

}
