package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	
	public Logger logger;    //Logger is the pre-defined class and created/defined variable logger
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"master","sanity","regression"})
	@Parameters({"browser"})                  //receiving the browser from xml file
	public void setup(String br)              //value of the browser is stored in the br variable
	{
    
	//Loading config.properties
	rb=ResourceBundle.getBundle("config");     //pass paramter as name of config file
		
	//Logging
	logger = LogManager.getLogger(this.getClass());                   //need to pass paramater as name of the class-which ever class currently executing but should not hardcode as we run multiple times--> dynamically should take the class name 
	
	
	//Driver	
	   if(br.equals("chrome"))
	   {
	   WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
	   }
	   else if(br.equals("edge"))
	   {
	   WebDriverManager.edgedriver().setup();
	   driver=new EdgeDriver();
	   }
	   else
	   {
		   WebDriverManager.chromedriver().setup();
	       driver=new ChromeDriver();
	   }
   
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
	}
	
	@AfterClass(groups= {"master","sanity","regression"})
	public void tearDown()
	{
		driver.close();
	}
	
	public String randomstring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
	public int randomnumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return(Integer.parseInt(generatedString2));
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}

}
