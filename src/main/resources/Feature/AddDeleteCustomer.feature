Feature: Add new customer as a Manager

@Regression
Scenario: Validate Add customer is successful

Given user is on XYZ bank page
Then user clicks on Manager Login
Then user clicks on add customer and enter customer details
|Hritik| Roshan| 100055|
Then clicks on add
And validates customer details are added successfully

#@Regression
#Scenario: Validate Add customer is successful
#
#Given user is on XYZ bank page
#Then user clicks on Manager Login
#Then user clicks on customer and delete customer
#Then clicks on add
#And validates customer details are added successfully
