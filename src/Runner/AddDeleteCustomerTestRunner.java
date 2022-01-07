package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
			features= "src\\Feature\\AddDeleteCustomer.feature",
			glue = {"StepDescription"},
			dryRun = false
		)

public class AddDeleteCustomerTestRunner {

}
