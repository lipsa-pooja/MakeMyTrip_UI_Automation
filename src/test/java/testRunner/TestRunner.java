package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/***
 * Runner class to Execute Scenarios from mentioned Feature files
 * @author lipsa
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = { "./src/test/resources/featureFiles/RoundTripTicketBooking.feature" }, 
				 glue = {"stepDefination", "appHooks" },
				 plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
				 dryRun = false

)
public class TestRunner {

}
