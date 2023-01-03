Feature: Homework week2

  Background:
    Given open the saucedemo website at https://www.saucedemo.com/

Scenario: Valid Login
When user logged in using "standard_user" and password as "secret_sauce"
Then user should be logged in

Scenario: Login with invalid username and valid password
When user logged in using "random_user" and password as "secret_sauce"
Then user shouldn't be able to log in
And display "Epic sadface: Username and password do not match any user in this service"

Scenario: Login with locked out user
When user logged in using "locked_out_user" and password as "secret_sauce"
Then user shouldn't be able to log in
And display "Epic sadface: Sorry, this user has been locked out."

Scenario: Login with valid username and invalid password
When user logged in using "standard_user" and password as "random_password"
Then user shouldn't be able to log in
And display "Epic sadface: Username and password do not match any user in this service"

Scenario: Login with no credentials
When user logged in with empty username and empty password
Then user shouldn't be able to log in
And display "Epic sadface: Username is required"

Scenario: Login with valid username and empty password
When user logged in using "standard_user" username and empty password
Then user shouldn't be able to log in
And display "Epic sadface: Password is required"

Scenario: Login with empty username and valid password
When user logged in using an empty username and "secret_sauce" password
Then user shouldn't be able to log in
And display "Epic sadface: Username is required"

Scenario: Login with valid username written in capital letters and valid password
  When user logged in using a valid username but written in capital letters and "secret_sauce" as password
  Then user shouldn't be able to log in
  And display "Epic sadface: Username and password do not match any user in this service"


