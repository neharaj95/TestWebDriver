package DemoTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;



public class BaseClass {
	public static WebDriver driver; // make it public so scope will be public and accessible to all
	public Properties prop; //make it public so scope will be public
	
	
	
	public WebDriver initializeDriver() throws IOException
	{
		
	    prop = new Properties();
		FileInputStream files=new FileInputStream("//Users//neharaj//eclipse-workspace//TestWebdriver//src//main//java//DemoTest//DataBrowsers.properties");
		prop.load(files);
		String broswerName=prop.getProperty("browser"); //it goes to prop file(DataBrowsers.properties) and check for browser value
		
		
		if(broswerName.equals("Chrome")) // can't use == operator as we r taking value from prop file
		{
			System.setProperty("webdriver.chrome.driver","chromedriver");
		    driver = new ChromeDriver();

		}
		
		else if (broswerName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver","⁨firefoxdriver"); // for mac use gecko driver
		    driver = new FirefoxDriver();
		}
		else if (broswerName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","⁨iedriver"); // for mac use gecko driver
		    driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// applies to all tcs ...wait for 10 sec before timeout
		
		return driver;	

	
	}
	
	public String Screenshot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screen=(TakesScreenshot)driver;
		File source= screen.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir") +"//reports//"+TestCaseName+".png"; // TestCaseName :this will save the screenshot with failed test case name
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	
		
	}
	

