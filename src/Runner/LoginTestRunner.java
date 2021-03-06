package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
			features= "src\\main\\resources\\Feature",
			glue = {"StepDescription"},
			dryRun = false,
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class LoginTestRunner {

}
