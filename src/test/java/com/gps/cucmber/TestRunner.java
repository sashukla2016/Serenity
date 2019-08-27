package com.gps.cucmber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources",
		glue = {"com/gps/cucumber/stepDefinition"},
		tags= {"@RegressionTest"},
		dryRun=false
		)

public class TestRunner {
	
	
}
