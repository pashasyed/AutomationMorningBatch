import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeLaunchDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		// This line of code will donwload rquired exe file of chromedriver with exact
		// matching version in backend

		WebDriver driver = new ChromeDriver();
		 // This will launch empty browser with out any url 
		
		driver.manage().window().maximize();
		// This will maximize the screen of launched browser
		
		driver.manage().deleteAllCookies();
		
		// This syntax will delete all cookies data.
		
		
		//Open any application from launched browser
		
		driver.get("https://github.com/");
		
		
		String applicaiton_title = driver.getTitle();
		// My requirment is to get opened url
		
		System.out.println(applicaiton_title);
		
		
		String application_url =driver.getCurrentUrl();  // This url will fetch from opened applicaiton
		System.out.println(application_url);
		
		
		Thread.sleep(5000); // In milliseconds
		
		// THis line of code will halt the execution
		
		driver.close();// This will close opened browser in selenium
		
		

	}

}
