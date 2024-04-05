
Feature: Login functionality

Background:
 
 
@sanity
Scenario: Successful login using valid credentials

 Given Browser launch
 Given User open the URL "https://practicetestautomation.com/practice-test-login/"
 When User enters Userid as "student" password as "Password123"
 And click on Submit
 Then success message should be "Logged In Successfully"
 And Logout
 And close the browser
 

@regression
Scenario Outline: Successful login using valid credentials
 
 Given Browser launch
 And User open the URL "https://practicetestautomation.com/practice-test-login/"
 When User enters Userid as "<user>" password as "<password>"
 And click on Submit
 Then success message should be "Logged In Successfully"
 And Logout
 And close the browser
 
Examples: 
|user||password|
|student||Password123|
|student||password|
 
 


