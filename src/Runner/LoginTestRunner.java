package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
			features= "src\\Feature\\login.feature",
			glue = {"StepDescription"},
			dryRun = false,
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class LoginTestRunner {

}
