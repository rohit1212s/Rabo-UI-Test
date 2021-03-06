package Cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", 
				glue = { "Stepdefinitions" }, 
				dryRun = false, 
				plugin = {"json:target/jsonReports/cucumber-report.json","json:target/reports.json"}, 
				monochrome = true, 
				tags="@registration or @homelink or @verifyaccount")

// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
public class TestRunner {

}
