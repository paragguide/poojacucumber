package testcases;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonUidTest extends Hook
{

	public static boolean login = false;
	
	@Given("I open {string} and get url {string} create report {string}")
	public void i_open_and_get_url_create_report(String browser, String url, String reportname) throws Exception 
	{
	    openBrowser(browser,url,reportname);
	}
	@Given("click signin")
	public void click_signin() 
	{
	    signin.click();
	}
	@When("I enter valid userid {string}")
	public void i_enter_valid_userid(String userid) 
	{
	    uid.sendKeys(userid);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("I validate the userid")
	public void i_validate_the_userid() throws Exception 
	{
		  try {
	   test.log(LogStatus.FAIL, err1.getText() );
	   utility.ScreenShot.takeScreenShot("UIdEror");
		  }
		  catch(Exception e)
		  {
			  test.log(LogStatus.PASS, "uid is valid..");
			  utility.ScreenShot.takeScreenShot("UIDPass");
		  }
	}
	@Then("check password textbox come")
	public void check_password_textbox_come() 
	{
	    if(pwd.isDisplayed())
	    {
	    	test.log(LogStatus.PASS, "Password txtbox is coming");
	    	login = true;
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Password txtbox not coming");
	    }
	}

}
