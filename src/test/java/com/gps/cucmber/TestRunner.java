package com.gps.cucmber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources",
		glue = {"com/gps/cucumber/stepDefinition"},
		tags= {"@smoke"},
		dryRun=false
		)

public class TestRunner {
	
	
}
