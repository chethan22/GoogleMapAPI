package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = {"stepDefinations"},plugin = {"json:target/cucumber-reports/cucumber.json"})
//tags = "@DeletePlace")

//plugin = {"pretty","html:target/cucumber-reports"}
//plugin = {"json:target/cucumber-reports/cucumber.json"}
//plugin = {"json:taget/jsonReports/cucumber-report.json"}
public class TestRunner {

}