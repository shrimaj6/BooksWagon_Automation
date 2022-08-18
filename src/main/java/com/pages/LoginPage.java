package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath = "//span[@class='usernametext']")
	WebElement userNameText;
	
	@FindBy(name="ctl00$phBody$SignIn$txtEmail")
	WebElement username;

	@FindBy(name = "ctl00$phBody$SignIn$txtPassword")
	WebElement password;

	@FindBy(id = "ctl00_phBody_SignIn_btnLogin")
	WebElement login;

	

	// initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	

	public HomePage login(String un, String pwd) {
		userNameText.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.submit();
		return new HomePage();
	}
	
	public HomePage loginMultipleAccounts(String un, String pass) {
		userNameText.click();
		username.sendKeys(un);
        password.sendKeys(pass);
        login.submit();
        return new HomePage();
		
	}
	
}