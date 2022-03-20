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

import test.Base_Class;

public class Login_Page  {

	WebDriver driver= Base_Class.driver;
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
	
	@FindBy(xpath="//span[@class='title']")
	public WebElement Login_pass_text;
	
	public Login_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void Login(String username1, String pass1)
	{
		user_name.sendKeys(username1);
		password.sendKeys(pass1);
		login_click.click();
		
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
