package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) // next step create constructor -get WebDriver instance from the test case and driver instance assign to local variable  -->purpose of constructor if we have any variable at the class and want to assign value in the variable
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement txtFirstName;                        //Note - all variables in page object classes are private
	
	@FindBy(name="lastname")
	private WebElement txtLastName;
	
	@FindBy(name="email")
	private WebElement txtEmail;
	
	@FindBy(name="telephone")
	private WebElement txtTelephone;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="confirm")
	private WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	private WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement btnContinue;
	
	@FindBy(xpath="//text()='Your Account Has Been Created!']")
	private WebElement msgConfirmation;
	
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfpwd)
	{
		txtConfirmPassword.sendKeys(cnfpwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
		return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}