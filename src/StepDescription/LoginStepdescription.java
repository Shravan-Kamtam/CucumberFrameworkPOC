package StepDescription;

import com.pages.CustomerLoginPage;
import com.pages.ManagerLoginPage;
import com.util.CommonFunctions;

import Base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepdescription extends TestBase {
	
	CustomerLoginPage lp;
	ManagerLoginPage mp;
	CommonFunctions cf;
	
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
		mp.managerLoginButton();
	}

	@Then("^clicks on open account and also customers$")
	public void clicks_on_open_account_and_also_customers() {
		mp.openAccountCustomersButton();
	}
	
}
