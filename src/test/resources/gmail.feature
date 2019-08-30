Feature: Gmail application 

Background:
	Given I login to the application successfully

@smoke
Scenario: Deleting emails from the account
	Given I navigate to social tab of inbox
	When I delete few emails 
	Then I should see the notification for deleted emails