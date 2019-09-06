Feature: Gmail application 

In order to delete an email from gmail account
As a valid user
I will select an email and delete it from the inbox of the gmail account 

Background:
	Given I login to the application successfully

@smoke
Scenario: Deleting emails from the account
	Given I navigate to primary tab of inbox
	When I delete an email
	Then I should see the notification for the deleted email