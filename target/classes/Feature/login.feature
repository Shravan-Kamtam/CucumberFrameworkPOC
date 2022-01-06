Feature: Login into XYZ bank

#Scenario: Validate customer login in XYZ Bank application
#
#Given user is on XYZ bank page
#Then user clicks on customer Login
#Then user selects customer from dropdown
#Then clicks on login
#And validates customer details


Scenario: Validate Manager login in XYZ Bank application

Given user is on XYZ bank page
Then user clicks on Manager Login and selects add customer
Then user enter details and clicks on add customer
And  validate customer added successful pop up