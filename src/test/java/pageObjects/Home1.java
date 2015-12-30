package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home1 {
	
	private static WebElement element = null;
	
	public static WebElement txt_name(WebDriver driver){	
	element = driver.findElement(By.xpath("//input[@name='nameform']"));
	return element;
	}
	
	public static WebElement txt_email(WebDriver driver){
	element = driver.findElement(By.xpath("//input[@name='emailform']"));
	return element;	
	}
	
	public static WebElement txt_Phone(WebDriver driver){
	element = driver.findElement(By.xpath("//input[@name='phonenoform']"));
	return element;
	}
	
	public static WebElement txt_webiste(WebDriver driver){
	element = driver.findElement(By.xpath("(//input[@name='website'])[1]"));
	return element;
	}
	
	public static WebElement txt_Message(WebDriver driver){
	element = driver.findElement(By.xpath("//textarea[@name='messageform']"));
	return element;
	}
	
	public static WebElement btn_submit(WebDriver driver){
	element = driver.findElement(By.id("submitcontactForm"));
	return element;
		
	}
}
