package StepDescription;

import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;

import Base.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Stepdescription extends TestBase {
	
//	HomePage hp = new HomePage();
	
	
	@Before
	public void initialization() {
		init();
	}
	 
	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^user is on xyz bank login page$")
	public void user_is_on_xyz_bank_login_page() {
		System.out.println("Init method already called");
	}

	@Then("^user clicks on customer login button$")
	public void user_clicks_on_customer_login_button() {
		LoginPage hp = new LoginPage();
		hp.clickOnCutomerLoginButton();
	}

	@Then("^under your name dropdown user selects Harry Potter$")
	public void under_your_name_dropdown_user_selects_Harry_Potter() {
		LoginPage hp = new LoginPage();
		hp.selectCustomer();
	}

	@Then("^clicks on login button$")
	public void clicks_on_login_button() {
		LoginPage hp = new LoginPage();
		hp.clickOnLoginButton();
	}

	@And("^user is on welcome page$")
	public void user_is_on_welcome_page() {
		System.out.println("This step is alread validated");
	}

}
