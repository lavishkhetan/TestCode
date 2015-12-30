package testLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CaseStudies {

	public WebDriver driver;
	public WebDriverWait wait;
	String appURL = "http://ishirqa.com/";
	String Actualtext;
	//Locators
	private By byName = By.xpath("//form[@id='applyForm']//input[@name='applyname']");
	private By byEmail = By.xpath(" //form[@id='applyForm']//input[@name='applyemail']");
	private By byPhoneNo = By.xpath("//form[@id='applyForm']//input[@name='applyphone']");
	private By byZipCode = By.xpath("//form[@id='applyForm']//input[@name='applyzcode']");
	private By byBusiness = By.xpath("//form[@id='applyForm']//input[@name='applybname']");
	private By byNoOfEmp = By.xpath("///form[@id='applyForm']//input[@name='applyemp']");
	private By byProdName = By.xpath("//form[@id='applyForm']//input[@name='applyproname']");
	private By byWebsite = By.xpath("//form[@id='applyForm']//input[@name='website']");
	private By byDescription = By.xpath("//form[@id='applyForm']/div[12]/textarea");

	
	@BeforeClass
	public void testSetup() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}
	
	@Test(priority = 1)
	public void caseStudies() throws InterruptedException{
		driver.get("http://ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000)", "");
		driver.findElement(By.id("learnmore")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("applynow")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 2, dataProvider="UserLogin")
	public void VerifyDataEntry(String userName, String emailAdd, String phoneNo, String zipCode, String businessName, String noOfEmp, String product, String websiteBlk, String describe) {
		
		driver.findElement(byName).sendKeys(userName);
		driver.findElement(byEmail).sendKeys(emailAdd);
		driver.findElement(byPhoneNo).sendKeys(phoneNo);
		driver.findElement(byZipCode).sendKeys(zipCode);
		driver.findElement(byBusiness).sendKeys(businessName);
		driver.findElement(byNoOfEmp).sendKeys(noOfEmp);
		driver.findElement(byProdName).sendKeys(product);
		driver.findElement(byWebsite).sendKeys(websiteBlk);
		driver.findElement(byDescription).sendKeys(describe);		
	}
	
	@DataProvider(name="UserLogin")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("C:\\Users\\lkhetan\\workspace\\myMaven\\src\\test\\java\\testData\\DataFile.xls","Data");
		return arrayObject;
	}

	public String[][] getExcelData(String DataFile, String Data) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(DataFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(Data);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	@Test(priority = 3)
	public void submitForm() throws InterruptedException{
		driver.findElement(By.id("submitapplyForm")).click();
		Thread.sleep(1000);
		Actualtext = driver.findElement(By.xpath("//section[@id='about']/div/div/div[1]/p")).getText();
     	Assert.assertEquals(Actualtext,"Our representative will contact you soon.");
     	System.out.println("Assertion Working for Submit page");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

