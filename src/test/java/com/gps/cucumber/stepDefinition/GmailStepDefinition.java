package com.gps.cucumber.stepDefinition;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Managed;
//import net.thucydides.core.annotations.locators.WaitForWebElements;
import net.thucydides.core.util.EnvironmentVariables;

public class GmailStepDefinition extends PageObject {
	//@Managed
	//WebDriver driver;
	EnvironmentVariables env;
	String url;
	WebDriverWait wait;
	public static Properties prop;

	//Page Objects
	@FindBy(xpath = "//input[@type='email' and @id='identifierId']")
	WebElementFacade userId;

	@FindBy(css = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
	WebElementFacade password;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElementFacade btn;

	@FindBy(xpath="//span[contains(text(),'Wrong password')]")
	WebElementFacade wrongPass;
	
	@FindBy(xpath="//div[@title='Delete']")
	WebElementFacade deleteBtn;
	
	@FindBy(xpath="//div[text()='Primary']")
	WebElementFacade primary;

	@FindBy(xpath="//span[contains(text(),'moved to Trash')]")
	WebElementFacade dltNotification;

	@FindAll(value = { @FindBy (xpath="//tr[@class='zA zE']/td[2]") })
	List<WebElementFacade> emails;

	
	@Given("^I login to the application successfully$")
	public void i_login_to_the_application_successfully() throws IOException {
		url= ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(env);
		
		openUrl(url);
		prop=new Properties();
		FileInputStream in=new FileInputStream("./serenity.properties");
		prop.load(in);
		System.out.println(userId.getValue());
		userId.waitUntilClickable();
		userId.click();
		userId.sendKeys(prop.getProperty("username"));


		btn.click();

		password.waitUntilVisible(); 
		password.click();
		password.sendKeys(prop.getProperty("password"));

		btn.click();
		
		Assert.assertFalse(wrongPass.isPresent());

	}

	@Given("^I navigate to primary tab of inbox$")
	public void i_navigate_to_primary_tab_of_inbox() {
		primary.waitUntilVisible();
		primary.click();
	}

	@When("^I delete an email$")
	public void i_delete_an_email() {
		
		emails.get(1).waitUntilClickable();
		emails.get(1).click();
		
		/*
		 * for(WebElementFacade em:emails) { em.waitUntilVisible();
		 * em.waitUntilClickable(); em.click(); }
		 */

		/*
		 * for(int i=0;i<2;i++) { emails.get(i).click(); }
		 */

		deleteBtn.click();

		//new Actions(driver).click(driver.findElement(By.cssSelector("div[aria-label='Delete']>div>div"))).perform();
	}

	@Then("^I should see the notification for the deleted email$")
	public void i_should_see_the_notification_for_the_deleted_email() {
		
		dltNotification.waitUntilVisible();
		Assert.assertTrue(dltNotification.isCurrentlyVisible());
		
	}


}
