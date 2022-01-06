package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features= "src\\Feature\\login.feature",
			glue = {"StepDescription"},
			dryRun = false
		)

public class LoginTestRunner {

}
