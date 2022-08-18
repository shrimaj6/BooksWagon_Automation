package com.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SearchPage;



public class SearchTestPage extends BaseClass{
	SearchPage searchPage;
	HomePage homePage;
	LoginPage loginPage;
	
	public SearchTestPage () {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		searchPage = new SearchPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifySearchPageTest() throws Exception{
		searchPage.clickSearchButton("Perspective Made Easy");
		
		searchPage.clickOnBookNow();
	}
	
}
