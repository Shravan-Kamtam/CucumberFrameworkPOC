package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.CommonFunctions;

import Base.TestBase;

public class LoginPage extends TestBase{

	WebElement customerLoginButton = driver.findElement(By.xpath("//input[@type='text']"));
	WebElement ManagerLoginButton = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
	WebElement HomeButton = driver.findElement(By.xpath("//button[text()='Home']"));
	WebElement userNameSelectDropdown = driver.findElement(By.xpath("//select[@name='userSelect']"));
	WebElement LoginButton = driver.findElement(By.xpath("//button[text()='Login']"));
	WebElement welcomeBanner = driver.findElement(By.xpath("//strong[text()=' Welcome ']"));
	
//	@FindBy(xpath = "//button[text()='Customer Login']")
//	WebElement customerLoginButton;
//
//	@FindBy(xpath = "//select[@name='userSelect']")
//	WebElement userNameSelectDropdown;
//
//	@FindBy(xpath = "//button[text()='Login']")
//	WebElement LoginButton;
//
//	@FindBy(xpath = "//strong[text()=' Welcome ']")
//	WebElement welcomeBanner;
	
	CommonFunctions cf = new CommonFunctions();
	
//	public HomePage() {
//		PageFactory.initElements(driver, this);
//	}
	
	
	public void clickOnCutomerLoginButton() {
		cf.javaScriptclick(customerLoginButton);		
	}
	
	public void selectCustomer() {
		cf.selectByVisiblTextfromDropdown(userNameSelectDropdown, property.getProperty("valueFromDropdown") , driver);		
	}
	
	public void clickOnLoginButton() {
		cf.javaScriptclick(LoginButton);
		Assert.assertTrue(welcomeBanner.isDisplayed());
	}
	
	
}
