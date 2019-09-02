package com.gps.cucumber.stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
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
	@Managed
	WebDriver driver;
	EnvironmentVariables env;
	String url;
	WebDriverWait wait;

	//Page Objects
	@FindBy(xpath = "//input[@type='email' and @id='identifierId']")
	WebElementFacade userId;

	@FindBy(css = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
	WebElementFacade password;

	//div[text()='Social']
	@FindBy(xpath="//div[text()='Primary']")
	WebElementFacade social;

	@FindBy(xpath="//span[contains(text(),'moved to Trash')]")
	WebElementFacade dltNotification;

	@FindAll(value = { @FindBy (xpath="//tr[@class='zA zE']/td[2]") })
	List<WebElementFacade> emails;

	@Given("^I login to the application successfully$")
	public void i_login_to_the_application_successfully() {
		url= ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(env);

		driver.manage().window().maximize();
		driver.get(url);

		System.out.println(userId.getValue());
		//=driver.findElement(By.xpath("//input[@type='email' and @id='identifierId']"));
		//WebElementFacade password=(WebElementFacade) driver.findElement(By.xpath("//input[@type='password']"));
		WebElement btn=driver.findElement(By.xpath("//span[text()='Next']"));

		userId.waitUntilClickable();
		userId.click();
		userId.sendKeys("stest735@gmail.com");


		btn.click();

		password.waitUntilVisible(); 
		password.click();
		password.sendKeys("S@1989test");

		WebElement btn2=driver.findElement(By.xpath("//span[text()='Next']"));

		btn2.click();

	}

	@Given("^I navigate to social tab of inbox$")
	public void i_navigate_to_social_tab_of_inbox() {


		//=(WebElementFacade)driver.findElement(By.xpath("//div[text()='Social']"));
		//social.findBy(By.xpath("//div[text()='Social']"));
		social.waitUntilVisible();
		social.click();
	}

	@When("^I delete few emails$")
	public void i_delete_few_emails() {
		//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr[@class='zA zE']/td[2]"))));

		//List<WebElement> emails=(List<WebElement>)driver.findElements(By.xpath("//tr[@class='zA zE']/td[2]"));

		for(int i=0;i<2;i++) {
			emails.get(i).waitUntilClickable();
			emails.get(i).click();
		}
		/*
		 * for(WebElementFacade em:emails) { em.waitUntilVisible();
		 * em.waitUntilClickable(); em.click(); }
		 */

		/*
		 * for(int i=0;i<2;i++) { emails.get(i).click(); }
		 */

		WebElement deleteBtn=driver.findElement(By.xpath("//div[@title='Delete']"));

		// WebElement dltBtn=driver.findElement(By.cssSelector("css=\"#\\\\:4 > div > div.nH.aqK > div.Cq.aqL > div > div > div:nth-child(2) > div.T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.mA\""));
		deleteBtn.click();

		new Actions(driver).click(driver.findElement(By.cssSelector("div[aria-label='Delete']>div>div"))).perform();
	}

	@Then("^I should see the notification for deleted emails$")
	public void i_should_see_the_notification_for_deleted_emails() {
		//span[contains(text(),'moved to Trash')]
		//WebElementFacade dltNotification=(WebElementFacade)driver.findElement(By.xpath("//span[contains(text(),'moved to Trash')]"));
		dltNotification.waitUntilVisible();

	}


}
