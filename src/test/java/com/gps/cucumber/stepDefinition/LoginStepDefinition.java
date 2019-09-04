package com.gps.cucumber.stepDefinition;

import org.openqa.selenium.support.FindBy;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;

public class LoginStepDefinition extends PageObject{

	//Page Objects
	@FindBy(id = "txtName")
	WebElementFacade username;
	
	@FindBy(id = "txtPassword")
	WebElementFacade password;
	
	@FindBy(id = "btnLogin")
	WebElementFacade loginBtn;
	
	EnvironmentVariables env;
	//
	
	//SerenityWebdriverManager driver;
	//@Step
	//@Screenshots(afterEachStep=true)
	/*
	 * This was another way to retrieve the base url from properties file
	 * EnvironmentVariables env;
	 * 
	 * public String getBaseUrl(){ return
	 * ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(env); }
	 */
	
	@Given("^I am on the application login page$")
	public void i_am_on_the_application_login_page() {
		
		String url=ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(env);
		openUrl(url);
		
	}

	//@Step
	//@Screenshots(afterEachStep=true)
	@When("^I login with valid credentials$") 
	public void i_login_with_valid_credentials() {
		
		username.sendKeys("saumyas");
		password.sendKeys("Saumya@12");
	}

	//@Step
	//@Screenshots(afterEachStep=true)
	@Then("^I am on the home page of the GPS application$")
	public void i_am_on_the_home_page_of_the_GPS_application(){
		
		loginBtn.click();
	}

}
