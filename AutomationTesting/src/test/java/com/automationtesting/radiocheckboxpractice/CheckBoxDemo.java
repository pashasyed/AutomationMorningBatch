package com.automationtesting.radiocheckboxpractice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {
	
	WebDriver driver;

	public void check_Value(String exped_checkbox) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://courses.letskodeit.com/practice");

		List<WebElement> all_checkboxs = driver.findElements(By.xpath("//div[@id='checkbox-example-div']//input"));
		
		for( WebElement checkbox  :   all_checkboxs) {
			
			String checkbox_value=checkbox.getAttribute("id");
			
			if(exped_checkbox.equals(checkbox_value)) {
				checkbox.click();
				break;
			}
		}

	}
	
	public void takeScreen_Image() throws IOException {
		
	    File src_locaiton=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	     File dest_location= new File("D:\\Students Projects\\AugustMorningBatch\\AutomationTesting\\checkbox.jpg");
	     
	     FileUtils.copyFile(src_locaiton, dest_location);
	}
	
	
	
	public void tearmDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		CheckBoxDemo refence= new CheckBoxDemo();
		
		refence.check_Value("benzcheck");
		refence.takeScreen_Image();
		refence.tearmDown();
		
	}

}
