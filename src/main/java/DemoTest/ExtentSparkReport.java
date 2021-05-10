package DemoTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSparkReport {
	
	static ExtentReports extent; // defining global so that other classes outside can also use
	
	
	public static ExtentReports extentReports()
	{
		String pathOfReport= System.getProperty("user.dir")+"\\reports\\indexnew.html";
		ExtentSparkReporter reports= new ExtentSparkReporter(pathOfReport);
		reports.config().setReportName("Test WebDriver Report New");
		reports.config().setDocumentTitle("Neha Automation WebPage");
		
		
		
	    extent = new ExtentReports();
		extent.attachReporter(reports);
		
		extent.setSystemInfo("Tester", "Neha Raj");
		return extent;
		
		
	}

}
