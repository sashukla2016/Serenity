package com.gps.cucumber.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LoginStepDefinition {

	//WebDriver driver=Hooks.driver;
	WebDriver driver;

	@Given("^launch the browser and open the application$")
	public void launch_the_browser_and_open_the_application() {
		
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\poi-4.1.0\\WebDriver\\chromedriver.exe"); 
		  driver = new ChromeDriver();
		 
		driver.get("http://www.ourgoalplan.com");
		
	}


	@When("^I login with valid credentials$") 
	public void i_login_with_valid_credentials() {
		driver.findElement(By.id("txtName")).sendKeys("saumyas");
		driver.findElement(By.id("txtPassword")).sendKeys("Saumya@12"); }


	@Then("^I login successfully$")
	public void i_login_successfully() throws InterruptedException {
		
		driver.findElement(By.id("btnLogin")).click();
	}

}
