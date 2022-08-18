package com.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;


public class HomePageTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	Logger  log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("****** Starting test cases execution  *******");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("************Login the Application**********************");
		log.info("Open Home Page");
	}

	@Test(priority = 1)
	public void HomePageTitleTest() throws InterruptedException {
		log.info("****** starting test case ******");
		log.info("******* HomePageTitleTest ******");
		log.info("Opening Home Page");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
		Thread.sleep(2000);
		log.info("Title Verified Successfully.....");
		log.info("****** ending test case ******");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		log.info("****** starting test case ******");
		log.info("******* verifyUserNameTest ******");
		Assert.assertTrue(homePage.verifyCorrectUserName());
		log.info("UserName Verified Successfully.....");
		log.info("****** ending test case ******");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		 log.info("browser is closed");
	}
}
