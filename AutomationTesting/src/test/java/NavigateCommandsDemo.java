import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateCommandsDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		//launch browser
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://google.com");
		
		driver.navigate().to("https://www.irctc.co.in/nget/train-search"); 
		
		driver.navigate().refresh(); // refresh particular web applicaiton
		
		// Now my driver in irctic my req is to go back to google page
		
		driver.navigate().back(); // google applicaiton
		
		// come back to irctc
		
		driver.navigate().forward(); // irctc application
		
		driver.close();
		
	}

}

