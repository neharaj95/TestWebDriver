package DemoTestng;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager; // import apache logger, don't import java logger
import org.apache.logging.log4j.Logger;


import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DemoTest.BaseClass;
import pageObjects.HomePage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// import all properties of BaseClass using extends keyword
public class NewTest extends BaseClass{
	
	public WebDriver driver; // if u won't define this here then screenshot will not capture and will throw driver error
	
	public static Logger log =LogManager.getLogger(NewTest.class.getName()); // we can define in everypage to get loggers
	
 HomePage hp= new HomePage();
	  	
  @BeforeTest(alwaysRun=true)
  public void openURL() throws IOException 
  {
	  driver=initializeDriver();
	  driver.get(prop.getProperty("urlTestEnv")); // from base class , passed value in properties and retrieving from there
	 // driver.get("https://www.google.com");
	  System.out.println("Driver Initialized and git learning");
	  System.out.println("pull the code to local machine for git learning");
	  log.info("Driver Initialized by log4j");
  }
	
  @Parameters({"URL"})
  @Test(priority=0)
  public void logIn(String url) {
	  
	 // HomePage hp= new HomePage();
	  driver.findElement(By.id(hp.userName)).click();
	  System.out.println(" LogIn method first method "+url);
	  System.out.println("To check it updates on git or not as psuh request");
	  log.info("Logged In User");
  }
  
  
  @Test(groups = {"Smoke"})
  public void demo2()
  {
	  System.out.println(" demo 2 "); 
	  driver.findElement(By.xpath(hp.password)).click();
	  
  }
  @Test
  public void demo1()
  {
	  System.out.println(" demo 1 ");  
  }
  @Test(priority=1)
  public void signUp()
  {
	  System.out.println(" sign up "); 
  }
  
  //@BeforeTest
  @Test(dependsOnMethods= {"validateUser"})
  public void cleanData() {
	  System.out.println("Will clear the data");
	  
  }
  @Test
  public void dbConnection()
  {
	  System.out.println("Db connection established");
  }
  @Test(description="validating user")
  public void validateUser()
  {
	  System.out.println("user validation ");
	  //description: It is the description for the method. Eg: @Test(description = “test method”)
  }
  @Test(groups = {"Smoke"})
  public void envCheck()
  {
	  System.out.println("ENv is up");
  }
  
  @Test(groups = {"Smoke"})
  public void  orderPlace()
  {
	  System.out.println("Place order");
  }
  
  @Test(enabled = false)
  public void proceedToCheckout()
  {
	  System.out.println("Script in progress");
  }
  @Test(timeOut=3000)
  public void paymentMethod()
  {
	  System.out.println("This method takes time to execute");
  }
  
  @Test(alwaysRun= true) // alwaysRun is an attribute
  public void getTitleOfPage()
  {
	  System.out.println("Get title");
	 // his is used when we want to make sure a method always runs even if the parameters on which the method depends, fails. 
	 // If set to true, this test method will always run. Eg: @Test(alwaysRun = true)
  }
  
  //dependsOnGroups
  //It is the list of groups this method depends on. Eg: @Test (groups = { “City” ,”State” })
  @Test(dependsOnGroups= {"Smoke"})
  public void validateTestEnvURL() 
  {
	  System.out.println("it depends upon smoke tests");
  }
  
  @Test(invocationCount=7,invocationTimeOut=30)
  public void selGrid() 
  {
	  System.out.println("run this method 7 times");
	  //It refers to the number of times a method should be invoked. It will work as a loop. Eg: @Test(invocationCount = 7) . Hence, this method will execute 7 times.
  //This refers to the maximum number of milliseconds a method should take for all the invocationCount to complete. This attribute will be ignored if invocationCount is not specified. Eg: @Test(invocationCount =7,invocationTimeOut = 30 )
  }
  
  @Parameters({"Username" , "Password"})
  @Test
  public void registration(String username, String password)
  {
	  System.out.println("Print userName " + username + " and Password " + password);
  }
  //Row stands for how many different data types test should run
  //how many values sending per test
  // [2][2] browser will invoke 2 times
  @DataProvider
  public Object[][] getData(){
  Object[][] data=new Object [2][2];// [1][2] null pointer exception
  data[0][0]="nraj1";
  data[0][1]="pass";
  
  data[1][0]="nraj2";
  data[1][1]="pass2";
  
return data;
  
  }
  
  @Test(dataProvider="getData")
  public void validateUserLogIn(String uName, String passWord)
  {
	
	  System.out.println(uName +"and"+ passWord);
  }
  
  
//  @Test
//  public void onTestFailure(ITestResult result) 
//  {
//	  System.out.println("failed " + result.getName()) ;
//  }
  
 // ---------------
  //database connection
//  private static Statement st;
//  public static String DB_URL = "jdbc:mysql://localhost/test";
////Database Username
//	public static String DB_USER = "root";
//	// Database Password
//	public static String DB_PASSWORD = "Admin@123";
//  @BeforeTest
//   public void setUpDB() throws Exception {
//
//	try {
//	//  String host="localhost";
//
//	//  String port= "3306";
//	  
//	  String dbClass = "com.mysql.cj.jdbc.Driver";
//      Class.forName(dbClass).newInstance();
//	  Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//	// Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root", "Admin@123"); // created connection
//	
//	  System.out.println("failed1");
//	 
//	  
//	  st=con.createStatement();
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//	}
//  }
//	
//	@Test
//	 public void test()
//	{
//		
//	try {
//	 String query="select * from emp";
//	 ResultSet rSet= st.executeQuery(query);
//	 
//	 System.out.println(rSet.getFetchSize());
//	 
//	 System.out.println("failed3");
//
//	 
//	 
//	
//	 
//	 
//	 
//	 //	 System.out.println();
//	// res.next() returns true if there is any next record else returns false
//	 while(rSet.next());
// {
//	 System.out.print(rSet.getString(1));
//// boolean val=rSet.next();
//// System.out.println(val);
////		 System.out.println("failed4");
////		 int empNum=rSet.getInt("empno");
////		// String empNum=rSet.getString("empno");
////	 System.out.println(empNum);
////	 System.out.println("failed5");
////	// rSet.close();
////	 
////  
////	 
// }
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//	}
//  
//  }
  // Log 4j
  //Loggers: It is responsible for logging information. To implement loggers into a project following steps need to be performed -
  //Create a Logger object inside the main class.
 // Invoke getLogger() method of Logger class and pass the className.class as an argument to it.
 // Use this object with any of the log levels with our own text.
//  Use log. Error() to log when elements are not displayed in the page or if any validations fail
//
//  Use Log. Debug()
//
//  When each Selenium action is performed like click, SendKeys, getText()
//
//  Use log.info()
//
//  When operation is successfully completed ex: After loading page, or after any successful validations
//
//  It’s just counterpart to log. Error()
  

//  private  Logger log=Logger.getLogger(NewTest.class.getName());
//  @Test
//  public void loggingInfo()
//  {
//	 log.debug("logging");
//	log.error("error msg");
//  }
  
//  
  
  private static Statement stmt;
	// Constant for Database URL
	public static String DB_URL = "jdbc:mysql://localhost/test";
	//Database Username
	public static String DB_USER = "root";
	// Database Password
	public static String DB_PASSWORD = "Admin@123";

	@BeforeTest
	public void setUp() throws Exception {
	try{
	// Database connection
	String dbClass = "com.mysql.cj.jdbc.Driver";
	Class.forName(dbClass).newInstance();
	// Get connection to DB
	Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	// Statement object to send the SQL statement to the Database
	stmt = con.createStatement();
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	}

	@Test
	public void test() {
	try{
	String query = "select * from emp";
	// Get the contents of userinfo table from DB
	ResultSet res = stmt.executeQuery(query);
	System.out.println(res.getFetchSize());
	// Print the result untill all the records are printed
	// res.next() returns true if there is any next record else returns false
	while (res.next())
	{
	System.out.print(res.getString(1));
	System.out.print(" " + res.getString(2));
	System.out.print(" " + res.getString(3));
	System.out.println(" " + res.getString(4));
	}
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	}

  
  
  
}
