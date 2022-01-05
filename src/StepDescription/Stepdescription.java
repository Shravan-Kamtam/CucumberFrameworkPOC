package StepDescription;

import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;

import Base.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Stepdescription extends TestBase {
	
	LoginPage lp;
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Given("^user is on XYZ bank page$")
	public void user_is_on_XYZ_bank_page() {
		init();
	}

	@Then("^user clicks on customer Login$")
	public void user_clicks_on_customer_Login() {
		lp = new LoginPage();
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
	
}
