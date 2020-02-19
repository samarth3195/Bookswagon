package com.bookswagon.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hpsf.Property;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;





import com.bookswagon.utilitiy.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

 

public class BaseClass {
	
	protected static ExtentTest test;
	protected static ExtentReports report;
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getEmail();
	public String password=readconfig.getPassword(); 
	
	
	 protected WebDriver driver; 
	public static Logger logger;
	
//	@BeforeSuite
//	public static void startTest()
//	{
//	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
//	test = report.startTest("ExtentDemo");
//	}
//	
//	@AfterSuite
//	public static void endTest()
//	{
//	report.endTest(test);
//	report.flush();
//	}
	
	
	@BeforeClass
	public void setupBrowser()
	{	
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		
		logger = logger.getLogger("BooksWagon");
		PropertyConfigurator.configure("./resource/Log4j.properties");
		
		
		
	}
	
	
//	@Parameters("browser")
//	@BeforeClass
//	public void setup(String br) throws InterruptedException
//	{
//		
//		if(br.equals("chrome"))
//		{
//		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());	
//		driver = new ChromeDriver();
//		}
//		else if (br.equals("ie"))
//		{
//			System.setProperty("webdriver.ie.driver",readconfig.getIepath());	
//			driver = new InternetExplorerDriver();
//		}
//		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get(baseURL);
//	
//		logger = Logger.getLogger("bookWagon");
//		PropertyConfigurator.configure("./Log4j.properties");	
//	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	
	
}
