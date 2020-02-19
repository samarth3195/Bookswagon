package com.bookswagon.execution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.bookswagon.pageobjects.BaseClass;
import com.bookswagon.pageobjects.homePage;
import com.bookswagon.pageobjects.searchBookPage;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class TC_Login_001 extends BaseClass {
	
	//private static final WebDriver driver = null;

	@Test (priority = 1)
	public void login() throws IOException
	{
		
		logger.info("URL OPEN");
		homePage hp = new homePage(driver);
		
		hp.clickheader();
		 
		hp.clickLoginBtn();
		
		logger.info("Username and Password being entered");
		hp.inputEmailAdd();
		
		hp.inputPassword();
		
		hp.clickSubmit();	
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if ( title.equals("Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		captureScreen(driver, "login");
		
		logger.info("Successfully Logged in");
		
	}
	
	
	@Test (priority = 2)
	public void Search() throws IOException
	{
		searchBookPage sp = new searchBookPage(driver);
		
		logger.info("Searching for books");

		sp.searchTextBox();	
		
		captureScreen(driver, "Search");
		
		String currentURL = driver.getCurrentUrl();
		
		if(currentURL.contentEquals(driver.getCurrentUrl()))
		{
			Assert.assertTrue(true);

		}
		else 
		{
			Assert.assertTrue(false);

		}

	}

}
