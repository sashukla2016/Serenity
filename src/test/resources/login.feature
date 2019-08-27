Feature: Goal Plan System application Login

@RegressionTest @End2End
Scenario: GPS Login Test Scenario
	Given launch the browser and open the application
	When I login with valid credentials
	Then I login successfully
	

