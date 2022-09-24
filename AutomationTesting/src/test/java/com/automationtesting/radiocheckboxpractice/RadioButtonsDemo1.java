package com.automationtesting.radiocheckboxpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonsDemo1 {

	public void select_Car(String exp_car) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://courses.letskodeit.com/practice");
		
		List<WebElement> allradio_btns = driver.findElements(By.xpath("//div[@id='radio-btn-example']//input"));

		for (WebElement radio_btn : allradio_btns) {

			String car_type = radio_btn.getAttribute("value");

			if (exp_car.equals(car_type)) { // False, False, True

				radio_btn.click();
				break;
			}

		}

	}

	public static void main(String[] args) {
		RadioButtonsDemo1 ref= new RadioButtonsDemo1();
		ref.select_Car("honda");
	}
}
