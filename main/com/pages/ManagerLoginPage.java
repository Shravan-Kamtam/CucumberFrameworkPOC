package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.CommonFunctions;

import Base.TestBase;

public class ManagerLoginPage extends TestBase{

	@FindBy(xpath = "//button[text()='Home']")
	WebElement Home;
	
	@FindBy(xpath = "//button[text()='Bank Manager Login']")
	WebElement managerLogin;
	
	@FindBy(xpath = "//button[contains(text(),'Customers')]")
	WebElement customersButton;
	
	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	WebElement addCustomerButton;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameTextbox;	

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postCode;	
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement addCustomerDetails;
	
	CommonFunctions cf = new CommonFunctions();
	
	public ManagerLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void managerLoginButton() {
			cf.javaScriptclick(managerLogin);
			cf.javaScriptclick(addCustomerButton);
	}
	
	public void enterCustomerDetails(String fname, String lname, String pcode) {
		cf.javaScriptEnterData(firstNameTextbox, fname);
		cf.javaScriptEnterData(lastNameTextbox, lname);
		cf.javaScriptEnterData(postCode, pcode);
	}
	public void clickonAddCustomer() {
		cf.javaScriptclick(addCustomerDetails);
		cf.acceptAlert();
	}
	
}










