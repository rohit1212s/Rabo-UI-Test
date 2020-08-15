package Cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", 
				glue = { "Stepdefinitions" }, 
				dryRun = false, 
				plugin = {"json:target/jsonReports/cucumber-report.json" }, 
				monochrome = true, 
				tags="@registration or @homelink or @verifyaccount")

public class TestRunner_class {

}
