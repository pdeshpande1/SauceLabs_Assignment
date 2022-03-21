package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import page.Home_page;
import page.Login_Page;

public class Login_TestCase extends Base_Class
{		
	Login_Page login;
	Home_page home; ;
	Base_Class baseclass= new Base_Class();
	
	
	//@Parameters({"Param1", "Param2"})
	@Test (testName="Loginfailure")
	public void Login_failure()//String UserName, String password
	{
		login =new Login_Page();
		String UserName= worksheet.getRow(1).getCell(0).getStringCellValue();
		String password= worksheet.getRow(1).getCell(1).getStringCellValue();
		login.Login(UserName, password);
		String Error_Msg=login.error_msg.getText();
		
		System.out.println(Error_Msg);
		baseclass.ScreenShot("image.png");
		
		String Expected_value="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(Error_Msg, Expected_value);
	}
	
	@Test
	public void Login_Pass()
	{
		login =new Login_Page();
		home= new Home_page();
		String username= worksheet.getRow(2).getCell(0).getStringCellValue();
		String password= worksheet.getRow(2).getCell(1).getStringCellValue();
		login.Login(username, password);
		Boolean status=home.Login_pass_text.isDisplayed();
		baseclass.ScreenShot("image1.png");
		Assert.assertEquals(true, status);
	}
}
