package com.automationtesting.alertspractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement confirm_button = driver.findElement(By.xpath("//input[@id='confirmbtn']"));

		confirm_button.click();

		// Now need to switch to alert

		Alert alert = driver.switchTo().alert();

		String alert_message = alert.getText();

		System.out.println(alert_message);

		alert.dismiss();

		Thread.sleep(3000);

		driver.close();
	}

}
