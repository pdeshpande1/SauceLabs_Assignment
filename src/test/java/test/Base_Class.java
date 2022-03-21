package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base_Class 
{
	public static  WebDriver driver;//declare driver object
	FileInputStream fin;
	XSSFWorkbook workbook; //declare object for excel workbook
	XSSFSheet worksheet;//declare object for excel worksheet
	public static ExtentReports report;	 //declare object for extent report. Extent report creates report
	public static ExtentTest test;//declare object for ExtenTest which writes/logs steps in report
	
	@BeforeTest
	public void DataSetup() throws IOException
	{
		fin= new FileInputStream("exceldata.xlsx");
		workbook= new XSSFWorkbook(fin); //instantiate object for workbook 
		worksheet= workbook.getSheet("Sheet1");
		report= new ExtentReports("Report.html");	
	}
	
	@BeforeMethod
	public void Launch_browser(Method method) throws IOException
	{
		test= report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();//driver object needs to  be instantiated always in BeforeMethod 
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='login_logo']")));	
	}
	
	@AfterMethod
	public void TearDown()
	{
		report.endTest(test);
		driver.close();
	}
	
	@AfterTest
	public void Stop_Process() throws Exception
	{
		workbook.close();
		report.flush();
		report.close();
	}
	
	public void ScreenShot(String fileWithPath)
	{
		TakesScreenshot screenshot= ((TakesScreenshot) driver);
		File file= screenshot.getScreenshotAs(OutputType.FILE);
		
		try
		{
			File DestFile=new File(fileWithPath);
			FileHandler.copy(file, DestFile);	
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
