package testCases;
//added comment for test case as part of github
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
   
   @Test(groups={"sanity","master"})	
   public void test_login() throws IOException
   {
	   logger.info("Starting TC_002_Login");
	   
	   try
	   {
		   driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked on Login ");
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email ");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			
			boolean targetpage=lp.isMyAccountPageExists();
			
			if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed ");
				captureScreen(driver, "test_Login"); //Capturing screenshot
				Assert.assertTrue(false);
			} 
	   }
	   catch(Exception e)
	   {
		   captureScreen(driver, "test_Login"); //Capturing screenshot
		   Assert.fail();
	   }
	   logger.info(" Finished TC_002_Login ");
   }
	
	
	
}
