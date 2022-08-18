package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.RequestBook;
import com.util.TestUtil;

public class RequestBookTest extends BaseClass{
	RequestBook requestBook;
	HomePage homePage;
	TestUtil testUtil;
	
	public RequestBookTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		requestBook = new RequestBook();
	}
	
	@Test(priority = 1)
	public void requestBookTitleTest() {
		String title = requestBook.validateRequestBookTitle();
		Assert.assertEquals(title, "Online Bookstore | Buy Books Online | Read Books Online");
	}
	
	@Test(priority = 2)
	public void Request_a_BookTest() {
	 requestBook.request(prop.getProperty("isbnElement"),
			 prop.getProperty("bookTitle"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

	}
	
}
