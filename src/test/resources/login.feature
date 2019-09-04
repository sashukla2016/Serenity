Feature: Goal Plan System application Login

@RegressionTest @End2End
Scenario: GPS Login Test Scenario
	Given I am on the application login page
	When I login with valid credentials
	Then I am on the home page of the GPS application
	

