package com.gps.cucmber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "C:\\Users\\Saumya\\SeleniumAutomation\\SerenityCucumberFramework\\src\\test\\resources\\login.feature",
		glue = {"com/gps/cucumber/stepDefinition"}
		)

public class LoginRunner {
	
	
}
