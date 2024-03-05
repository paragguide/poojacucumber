package testcases;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSearch //extends Hook
{
boolean x = false;

	/*
	@Given("i browse {string} open website {string} create report {string}")
	public void i_browse_open_website_create_report(String browser, String url, String reportname) throws Exception
	{
	   openBrowser(browser,url,reportname);
	}*/
	
	@Given("i am logged in")
	public void i_am_logged_in()
	{
		if(AmazonPwdTest.login == true)
		{ 
			x = true;
		}
	}
	
	@When("^i search product (.*) in price range (.*)")
	public void i_search_product_in_price_range(String prodname,int price) throws Exception 
	{
		   if(x == true)
		   {
		Hook.searchbox.clear();	   
	   Hook.searchbox.sendKeys(prodname+" in range rs "+price);
	   Actions a = new Actions(Hook.driver);
	   a.sendKeys(Keys.ENTER).perform();
	   
	   utility.ScreenShot.takeScreenShot(prodname+"SearchResult");
		   }
	}
	@Then("search results must come")
	public void search_results_must_come() 
	{
		Iterator <WebElement> it =  Hook.searchresult.iterator();
		 while(it.hasNext())
		 {
			 WebElement e = it.next();
			 Hook.test.log(LogStatus.INFO, e.getText());
			 
		 }
		 
		// Hook.afterTest() ;
	}



}
