package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.CommonFunctions;

import Base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//button[text()='Customer Login']")
	WebElement customerLogin;

	@FindBy(xpath = "//button[text()='Bank Manager Login']")
	WebElement managerLogin;

	@FindBy(xpath = "//select[@name='userSelect']")
	WebElement selectCustomerDropdown;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	
	CommonFunctions cf = new CommonFunctions();
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnCustomerLogin() {
		cf.javaScriptclick(customerLogin);
	}
	
	public void selectCustomer() {
		cf.selectByVisiblTextfromDropdown(selectCustomerDropdown, property.getProperty("username"));	
	}
	
	public void clickOnLoginButton() {
		cf.javaScriptclick(loginButton);
	}
	
	
}
