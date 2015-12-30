package testLogin;

import org.testng.annotations.Test;
import appModule.Actions;
import pageObjects.Home1;
import pageObjects.Login1;
import pageObjects.Logout1;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class LetsTalk {
	public WebDriver driver; 
	public String expected = null;
	public String Actualtext;
	public WebDriverWait wait;
	
	@BeforeTest(alwaysRun = true)
		public void Browser() {
		driver =  new FirefoxDriver();
  		driver.manage().window().maximize();
  		wait = new WebDriverWait(driver, 5);
		driver.get("http://www.ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login into the account");
	}
	@Test
	public void Dashboard(){
		Actualtext=driver.findElement(By.xpath("//div[@class='logo']/p")).getText();
	    Assert.assertEquals(Actualtext, "Software Quality Assurance Services");
	    System.out.println("Verified the Dashboard");
	}
	
	@Test(priority = 1)
 		public void ScrollPageDown(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4000)", "");
		}	
//		This will launch the browser, Verify the Dashboard and scroll down the page 
		
	 @Test(priority = 2)
		public void FormField() throws InterruptedException{
			Actions.Execute(driver);
			Thread.sleep(1000);
			Actualtext = driver.findElement(By.xpath("//section[@id='about']/div/div/div[1]/p")).getText();
	     	Assert.assertEquals(Actualtext,"Our representative will contact you soon.");
	     	System.out.println("Assertion Working for Submit page");
		  }
//		Once scrolled down, This will fetch all the values of home page FormField from Actions class
		 		  
		  @AfterTest
		  public void afterTest() {		  
		  driver.quit();
		  }

		}

