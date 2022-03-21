package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Base_Class;

public class Login_Page  {

	//instead of creating driver instance object for this class, point driver object to Base class Webdriver class
	WebDriver driver= Base_Class.driver; 
	public  ExtentReports report= Base_Class.report;
	public  ExtentTest test = Base_Class.test;
	Login_Page login;
	String username;
	String pass;
	
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement user_name;
	
	@FindBy(xpath="//input [@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login-button']")
	WebElement login_click;
	
	@FindBy(xpath="//div[@class='error-message-container error']/h3")
	public WebElement error_msg;
	
	
	
	public Login_Page()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void Login(String username1, String pass1)
	{
		user_name.sendKeys(username1);
		test.log(LogStatus.PASS, "Enter username", "Username entered successfully");
		password.sendKeys(pass1);
		test.log(LogStatus.PASS, "Eneter password", "Password entered sucessfully");
		login_click.click();
		test.log(LogStatus.PASS, "Click login button", "Login button clicked successfully");
	}
	
}
