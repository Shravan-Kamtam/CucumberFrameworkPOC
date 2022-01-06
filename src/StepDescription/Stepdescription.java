package StepDescription;

import org.openqa.selenium.WebDriver;

import com.pages.CustomerLoginPage;
import com.pages.ManagerLoginPage;

import Base.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Stepdescription extends TestBase {
	
	CustomerLoginPage lp;
	ManagerLoginPage mp;
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	//Customer Login flow
	@Given("^user is on XYZ bank page$")
	public void user_is_on_XYZ_bank_page() {
		init();
	}

	@Then("^user clicks on customer Login$")
	public void user_clicks_on_customer_Login() {
		lp = new CustomerLoginPage();
		lp.clickOnCustomerLogin();
	}

	@Then("^user selects customer from dropdown$")
	public void user_selects_customer_from_dropdown() {
		lp.selectCustomer();
	}

	@Then("^clicks on login$")
	public void clicks_on_login() {
		lp.clickOnLoginButton();
	}

	@Then("^validates customer details$")
	public void validates_customer_details() {
		System.out.println("Customer details validate");
	}
	
	
	//Manager Login Flow	
	@Then("^user clicks on Manager Login and selects add customer$")
	public void user_clicks_on_Manager_Login_and_selects_add_customer() {
		mp = new ManagerLoginPage();
		mp.clickonAddCustomer();
	}

	@Then("^user enter details and clicks on add customer$")
	public void user_enter_details_and_clicks_on_add_customer() {
		mp.enterCustomerDetails("fs", "ff", "4111");
		mp.clickonAddCustomer();
	}

	@Then("^validate customer added successful pop up$")
	public void validate_customer_added_successful_pop_up() {
		
	}
	
}
