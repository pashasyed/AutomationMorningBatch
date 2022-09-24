package com.automationtesting.externaldatareadingconcept;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeTest {

	static Properties pr;

	static WebDriver driver;

	public static void readProperties() throws IOException {

		String project_location = System.getProperty("user.dir");

		BufferedReader reader = new BufferedReader(new FileReader(project_location + "\\TestData.properties"));

		pr = new Properties();

		pr.load(reader);

	}

	public static void setUp(String url) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get(url);
	}

	public static void login_LedCodeApplicaiton(String username, String password) {

		driver.findElement(By.xpath("//input[@name= 'email']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys(password);

		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	}
	
	public static void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);
		
		driver.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		readProperties();

		String page_url = pr.getProperty("URL");
		String username = pr.getProperty("username");
		String password = pr.getProperty("password");

		setUp(page_url);
		login_LedCodeApplicaiton(username, password);
		tearDown();

	}
}
