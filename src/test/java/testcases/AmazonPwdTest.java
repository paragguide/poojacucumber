package testcases;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPwdTest 
{
boolean x = false;
public static boolean login = false;
	@Given("userid is valid and password txtbox displayed")
	public void userid_is_valid_and_password_txtbox_displayed() 
	{
	    if(AmazonUidTest.login == true)
	    {
	    	x = true;
	    }
	}
	@When("i enter correct password {string}")
	public void i_enter_correct_password(String password) 
	{  
		if(x == true)
		{
			Hook.pwd.sendKeys(password);
			Hook.submit.click();
		}
	    
	}
	@Then("i should login")
	public void i_should_login() throws Exception 
	{
		   try {
	   Hook.test.log(LogStatus.FAIL, Hook.err2.getText());
		   }
		   catch(Exception e)
		   {
			   Hook.test.log(LogStatus.PASS, "Logged in");
			   utility.ScreenShot.takeScreenShot("Loggedin");
			   login = true;
		   }
		   
		//  Hook. afterTest() ; // close browser..
	}

}
