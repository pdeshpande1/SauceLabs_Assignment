package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.Login_Page;

public class Login_TestCase extends Base_Class
{		
	Login_Page login =new Login_Page();
	
	@Test
	public void Login_failure()
	{
		login.Login("standard_user", "xyz");
		String Error_Msg=login.error_msg.getText();
		
		System.out.println(Error_Msg);
		login.ScreenShot("image.png");
		
		String Expected_value="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(Error_Msg, Expected_value);
	}
	
	@Test
	public void Login_Pass()
	{
		login.Login("locked_out_user", "secret_sauce");
		Boolean status=login.Login_pass_text.isDisplayed();
		login.ScreenShot("image1.png");
		Assert.assertEquals(true, status);
	}
}
