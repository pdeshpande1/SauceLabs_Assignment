package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Base_Class;

public class Home_page  {
	
	WebDriver driver= Base_Class.driver;
	Home_page home;
	
	@FindBy(xpath="//span[@class='title']")
	public WebElement Login_pass_text;
	
	public Home_page()
	{
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
