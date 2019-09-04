Feature: Gmail application 

Background:
	Given I login to the application successfully

@smoke
Scenario: Deleting emails from the account
	Given I navigate to primary tab of inbox
	When I delete an email 
	Then I should see the notification for the deleted email