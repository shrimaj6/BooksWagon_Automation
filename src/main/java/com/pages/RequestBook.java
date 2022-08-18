package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class RequestBook extends BaseClass{
	
	@FindBy(linkText = "Request a Book")
	WebElement requestBook;
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtISBN']")
	WebElement isbnElement;
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtAuthor']")
	WebElement author;
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtEmailReq']")
	WebElement email;
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtTitle']")
	WebElement bookTitle;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_RequestBook_txtQty']")
	WebElement quantity;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_RequestBook_txtPhone']")
	WebElement mobile;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_RequestBook_imgbtnSave']")
	WebElement submitButton;
	
	public RequestBook() {
		PageFactory.initElements(driver, this);	
	}
	
	public String validateRequestBookTitle() {
		return driver.getTitle();
	}
	
	public void request(String isbn, String bt) {
		requestBook.click();
		isbnElement.sendKeys(isbn);
		bookTitle.sendKeys(bt);
		submitButton.submit();

	}
	
	
	
	
	
	
	
}