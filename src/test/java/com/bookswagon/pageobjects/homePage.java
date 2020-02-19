package com.bookswagon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	WebDriver ldriver;
	
	public homePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//a[text()='Login']") WebElement login;
	
	@FindBy(xpath = "//*[@id='header']/div[5]/a[2]") WebElement header;
	
	@FindBy(xpath = "//input[@name ='ctl00$phBody$SignIn$txtEmail']") WebElement emailAdd;
	
	@FindBy(xpath = "//input[@name ='ctl00$phBody$SignIn$txtPassword'] ") WebElement pass;
	
	@FindBy(xpath = "//input[@name ='ctl00$phBody$SignIn$btnLogin'] ") WebElement loginBtn;

	
	
	public void clickheader()
	{
		header.click();
	}
	public void clickLoginBtn()
	{
		login.click();
	}
	public void inputEmailAdd()
	{
		emailAdd.click();
		emailAdd.sendKeys("sam123@gmail.com");
	}
	public void inputPassword()
	{
		pass.click();
		pass.sendKeys("Sam123");
	}
	
	public void clickSubmit()
	{
		loginBtn.click();
	}
	
	

}
