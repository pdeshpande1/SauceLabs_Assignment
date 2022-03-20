package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Base_Class 
{
	public static  WebDriver driver= new ChromeDriver();
	
	@BeforeMethod
	public void Launch_browser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='login_logo']")));	
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
	
}
