package com.bookswagon.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchBookPage {

	WebDriver ldriver;
	
	public searchBookPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//input[@name ='ctl00$TopSearch1$txtSearch']") WebElement searchbox;

	
	public void searchTextBox()
	{
		searchbox.click();
		searchbox.clear();
		searchbox.sendKeys("jeweled fire",Keys.ENTER);
		//searchbox.sendKeys(Keys.ENTER);
	}
}
