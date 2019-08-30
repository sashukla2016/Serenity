package com.gps.cucumber.stepDefinition;

import org.apache.tools.ant.property.GetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class LoginStepDefinition{

	//WebDriver driver=Hooks.driver;
	@Managed
	WebDriver driver;
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
	
	@Given("^launch the browser and open the application$")
	public void launch_the_browser_and_open_the_application() {
		//System.out.println("UURRRLLLLL"+url);
		 // System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); 
		  //driver = new ChromeDriver();
		//driver.get("http://www.ourgoalplan.com");
		String url=ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(env);
		driver.get(url);	
	}

	//@Step
	//@Screenshots(afterEachStep=true)
	@When("^I login with valid credentials$") 
	public void i_login_with_valid_credentials() {
		driver.findElement(By.id("txtName")).sendKeys("saumyas");
		//Serenity.takeScreenshot();
		//Serenity.recordReportData();
		driver.findElement(By.id("txtPassword")).sendKeys("Saumya@12"); }

	//@Step
	//@Screenshots(afterEachStep=true)
	@Then("^I login successfully$")
	public void i_login_successfully() throws InterruptedException {
		
		driver.findElement(By.id("btnLogin")).click();
		//Serenity.takeScreenshot();
	}

}
