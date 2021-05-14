package DemoTestng;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DemoTest.BaseClass;
import DemoTest.ExtentSparkReport;

public class NewTest2 extends BaseClass{
	public static Logger log =LogManager.getLogger(NewTest2.class.getName()); 
	@Test
	public void searchCart() throws IOException {
		driver=initializeDriver();
		driver.get("https://www.rahulshettyacademy.com/#/index");
		System.out.println("Search for items");
	
		
	}
	//@Test(priority=1)
	 @Test(groups = {"Smoke"})
	public void proceedToCheckout()
	{
		
		System.out.println("Checkout page");
	}
	
	@Test(priority=1)
	public void xaddToCart()
	{
		System.out.println("add to cart");
	}
	
	@BeforeMethod
	public void sessionTimeout()
	{
		System.out.println("To check session timeout");
		
	
		
	}
//	@AfterTest
//	public void closeBrowser()
//	{
//		System.out.println("close browser");
//		driver.quit();
//	}
	
	
	
	
}


