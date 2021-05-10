package DemoTestng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import DemoTest.BaseClass;
import DemoTest.ExtentSparkReport;

public class Listners extends BaseClass implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentSparkReport.extentReports();
	ThreadLocal<ExtentTest> ExtTest= new ThreadLocal<ExtentTest>(); // for parallel execution we use threadsafe (very impt)
	
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName()); // test is obj now which will be used further in this class
		ExtTest.set(test); // for parallel execution I am using obj(ExtTest) of Threadlocal
	}

	public void onTestSuccess(ITestResult result) {
		
		// in case of test cases pass, control move here and execute
	//	test.log(Status.PASS, "Test Passed");
		ExtTest.get().log(Status.PASS, "Test Passed"); // This ExtTest obj is used here for parallel execution
	}

	public void onTestFailure(ITestResult result) {
	//	test.fail(result.getThrowable());
		ExtTest.get().fail(result.getThrowable());// This ExtTest obj is used for parallel execution
		WebDriver driver=null;
		
		String failedMethodname=result.getMethod().getMethodName(); // it will give the name of failure method (very impt)
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		try {
			ExtTest.get().addScreenCaptureFromPath(Screenshot(failedMethodname,driver), result.getMethod().getMethodName()); // to capture screenshot on failure impt
			//Screenshot(failedMethodname,driver);//this method is present in base class which excpects a parameter
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
