package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.base.BaseClass;

public class ChangePassword extends BaseClass{

	@FindBy(xpath = "//span[@class='text-white accountred']//img")
	WebElement profile;
	@FindBy(name="ctl00$phBody$SignIn$txtEmail")
	WebElement username;
	@FindBy(id = "ctl00_phBody_SignIn_txtPassword")
	WebElement password;
	@FindBy(id = "ctl00_phBody_SignIn_btnLogin")
	WebElement login;
	@FindBy(linkText = "Change Password")
	WebElement changePassword;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_ChangePassword_txtCurPwd']")
	WebElement currentPassword;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_ChangePassword_txtNewPassword']")
	WebElement newPassword;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_ChangePassword_txtConfirmPwd']")
	WebElement confirmPassword;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_ChangePassword_imgSubmit']")
	WebElement changepasswordSubmit;
	
	public ChangePassword() {
		PageFactory.initElements(driver, this);	
	}
	
	public String validatechangePasswordPageTitle() {
		return driver.getTitle();
	}
	
	public void changePasswordofBookswagon(String un,String pwd,String cp, String np,String confirmp) {
		profile.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		changePassword.click();
		currentPassword.sendKeys(cp);
		newPassword.sendKeys(np);
		confirmPassword.sendKeys(confirmp);
		changepasswordSubmit.submit();
	
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

	}
	
}