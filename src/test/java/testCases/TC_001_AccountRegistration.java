package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass 
{
	@Test(groups={"regression","master"})
	public void test_account_registration() throws IOException
	{
		
		logger.info("Starting TC_001_AccountRegistration");
		try
		{
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		logger.info("Clicked on Register ");
		
		logger.info("Provided Customer details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("John");
		logger.info("Provided First Name ");
		
		regpage.setLastName("Canedy");
		logger.info("Provided Last Name ");
		
		regpage.setEmail(randomstring()+"@gmail.com");
		//regpage.setEmail("abc");
		logger.info("Provided Email ");
		
		regpage.setTelephone("65656565");
		logger.info("Provided Telephone ");
		
		regpage.setPassword("abcxyz");
		logger.info("Provided Password ");
		
		regpage.setConfirmPassword("abcxyz");
		logger.info("Provided Confirmed Password ");
		
		regpage.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");
		
		regpage.clickContinue();
		logger.info("Clicked on Continue ");
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		else
		{			
			logger.error("Account Registration Failed ");
			captureScreen(driver,"test_account_registration");   //capturing screenshot
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			captureScreen(driver,"test_account_registration");
			logger.fatal(" Account Registration Failed ");
			Assert.fail();
		}
		logger.info(" Finished TC_001_AccountRegistration ");
	}
}
