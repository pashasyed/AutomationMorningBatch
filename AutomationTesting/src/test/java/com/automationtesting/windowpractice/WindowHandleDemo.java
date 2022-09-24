package com.automationtesting.windowpractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://github.com/login");

		String parent_window = driver.getWindowHandle();

		WebElement login_textbox = driver.findElement(By.xpath("//input[@id='login_field']"));

		login_textbox.clear();

		login_textbox.sendKeys("gurumohanreddymadem@gmail.com");

		WebElement password_textbox = driver.findElement(By.xpath("//input[@id='password']"));

		password_textbox.clear();

		password_textbox.sendKeys("Testing@123");

		driver.findElement(By.xpath("//input[@value='Sign in']")).click();

		String operation = Keys.chord(Keys.CONTROL, Keys.ENTER);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[starts-with(@href,'/password')]")).sendKeys(operation); // 2 windows

		// after this 2 windows is opened

		Set<String> all_windows = driver.getWindowHandles(); // allwindow are storing in set

		for (String window : all_windows) {

			driver.switchTo().window(window); // any window

			String switced_win_url = driver.getCurrentUrl();
			
			System.out.println("Switched window url is ::"+switced_win_url);

			String exp_url = "https://github.com/password_reset";

			if (switced_win_url.equals(exp_url)) { // True will execute  // False
				WebElement verify_mail = driver.findElement(By.xpath("//input[@name='email']"));
				verify_mail.clear();
				verify_mail.sendKeys("gurumohanreddy@gmail.com");
				break;
			}
		}

	}

}
