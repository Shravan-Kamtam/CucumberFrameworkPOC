package StepDescription;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.pages.ManagerLoginPage;
import com.util.CommonFunctions;

import Base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddDeleteCustomerSteps extends TestBase {

	Logger log = Logger.getLogger(this.getClass().getName());
	ManagerLoginPage mp;
	
	@AfterStep
	public void scrnsht(Scenario scenario) throws IOException {	
		scenario.attach(CommonFunctions.getByteScreenshot(), "image/png", "test");
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Then("^user clicks on Manager Login$")
	public void user_clicks_on_manager_login() {
		mp = new ManagerLoginPage();
		mp.managerLoginButton();
	}

	@Then("^user clicks on add customer and enter customer details$")
	public void user_clicks_on_add_customer_and_enter_customer_details(DataTable table) throws InterruptedException {
		mp.enterCustomerDetails(table.cell(0, 0), table.cell(0, 1), table.cell(0, 2));
	}

	@Then("^clicks on add$")
	public void clicks_on_add() {
		mp.clickonAddCustomer();
	}

	@Then("^validates customer details are added successfully$")
	public void validates_customer_details_are_added_successfully() {
		log.info("********Customer Added Successfully********");
	}
}
