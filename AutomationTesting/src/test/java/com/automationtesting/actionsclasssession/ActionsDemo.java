package com.automationtesting.actionsclasssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		// this line will create chromedriver object/instance

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement doubleclick_btn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

		Actions action = new Actions(driver);
		// this line will create action class object/ instance

		action.moveToElement(doubleclick_btn).doubleClick().perform();  // with out perform method actions class won't execute it will skip

		Alert alert = driver.switchTo().alert(); 
		// this line will move our instance to alert window/popup

		String alert_message = alert.getText();

		System.out.println("Double click alert message is ::"+alert_message);

		alert.accept();

		Thread.sleep(2000);

		driver.close();

	}

}
