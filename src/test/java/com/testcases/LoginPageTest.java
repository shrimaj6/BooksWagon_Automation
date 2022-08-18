package com.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.TestUtil;
public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName = "Sheet1";
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();

	}
	

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Bookstore | Buy Books Online | Read Books Online");
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("login successful with username and Password");
	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	public void multipleLoginTest(String userName, String password) throws InterruptedException {
		homePage = loginPage.loginMultipleAccounts(userName, password);
		Thread.sleep(3000);
		log.info("login successful with username: " + userName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

	}
}