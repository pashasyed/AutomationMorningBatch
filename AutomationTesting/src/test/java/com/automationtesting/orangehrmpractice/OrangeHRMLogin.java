package com.automationtesting.orangehrmpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLogin {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		// This line automaticllay download requied exe of browser with same version

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		// How to open particular url

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Now my requireement is to enter text in textbox

		// sendkeys(text)--> we are using to enter text

		Thread.sleep(2000);// This will halt execution

		driver.findElement(By.name("username")).sendKeys("Admin");

		Thread.sleep(2000);

		driver.findElement(By.name("password")).sendKeys("admin123");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);

		// By using click() we can able to click on any button in application

		// My requiremtn how you know that you successfully logged into application

		String expected_url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

		String actual_url = driver.getCurrentUrl();// after login if we pass this getcurrenturl();
		
		if(expected_url.equalsIgnoreCase(actual_url)) {  // If both are same it will true
			
			 // true will get executed
			System.out.println("Successfully logged in");
			
			String title=driver.findElement(By.tagName("h6")).getText();
			
			System.out.println("OrangeHRM title is::"+title);
			
			driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			
		}
		else {
		   //false area will going to execute
			 System.out.println("Not logged in Succesfully, please enter valid credentails");
		}
		
		Thread.sleep(2000);
		
		driver.close();
		  // This will close browser after 2 seconds

	}

}
