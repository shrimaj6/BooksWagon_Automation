package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.ChangePassword;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class ChangePasswordTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ChangePassword changePassword;
	
	public ChangePasswordTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		changePassword = new ChangePassword();

	}
	
	@Test(priority = 1)
	public void changePasswordTitleTest() {
		String title = changePassword.validatechangePasswordPageTitle();
		Assert.assertEquals(title, "Online Bookstore | Buy Books Online | Read Books Online");
	}
	
	@Test(priority = 2)
	public void changePasswordofbooksawagonwithNewPassword() {
	 changePassword.changePasswordofBookswagon(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("currentPassword"),
			 prop.getProperty("newPassword"),prop.getProperty("confirmPassword"));
	}
	
	
	
}