package appModule;

import org.openqa.selenium.WebDriver;

import pageObjects.Home1;
import pageObjects.Login1;

public class Actions {

	WebDriver driver =null;
	public static void Execute(WebDriver driver){
	
	  Home1.txt_name(driver).sendKeys("Test");
	  Home1.txt_email(driver).sendKeys("lkhetan@ishir.com");
	  Home1.txt_Phone(driver).sendKeys("9999999999");
	  Home1.txt_webiste(driver).sendKeys("www.ishiqatest1.com");
	  Home1.txt_Message(driver).sendKeys("Nothing");
	  Home1.btn_submit(driver).click();
	}
	
}
