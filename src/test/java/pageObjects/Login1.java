package pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login1 {
	
 	public static WebDriverWait wait;
 	WebDriver driver =null;

		public static void Browser(WebDriver driver) {
	  		driver =  new FirefoxDriver();
	  		driver.manage().window().maximize();
	  		wait = new WebDriverWait(driver, 5);
			driver.get("http://www.ishirqa.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Login into the account");
		}
	}
	

