package core;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public class Page 
{
	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	
  
  public void openBrowser(String browser,String url,String reportname) throws Exception
  {
	 
		  // report....
		  String reportpath = System.getProperty("user.dir")+"\\src\\test\\java\\reports\\"+reportname+".html";
	       report = new ExtentReports(reportpath);
	       test = report.startTest(reportname);
	       
	       // open browser...
	       if(browser.equalsIgnoreCase("chrome"))
	    	{
	    		driver = new ChromeDriver();
	    	}
	    	else if(browser.equalsIgnoreCase("edge"))
	    	{
	    		driver = new EdgeDriver();
	    	}
	    	else if(browser.equalsIgnoreCase("firefox"))
	    	{
	    		driver = new FirefoxDriver();
	    	}
	    	
	    	driver.navigate().to(url); // prefered - can go back / forward
	    	
	    	   test.log(LogStatus.PASS, "browser "+browser+" url "+url+" opens..");
	    	
	    	PageFactory.initElements(driver, this); // compulsory to read external xpath
	    	
	    	 // implicit wait..
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
	    	
	    	driver.manage().window().maximize();
		  
	  
	  
  }

 
  public static void afterTest() 
  {
	  driver.quit();
	report.endTest(test);
  	report.flush();
  }

}
