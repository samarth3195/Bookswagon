package com.bookswagon.execution;

import org.testng.annotations.Test;

import com.bookswagon.pageobjects.BaseClass;
import com.bookswagon.pageobjects.searchBookPage;

public class TC_SearchBooks_002 extends BaseClass {

	
	@Test
	public void Search()
	{
		searchBookPage sp = new searchBookPage(driver);
		
		sp.searchTextBox();			
	}
}
