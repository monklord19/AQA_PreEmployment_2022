Feature: Homework1
  Background: User opens https://www.saucedemo.com/
    Given user opens website
  Scenario: Login with valid credentials
    Given user enters a valid username as standard_user
    And user enters a valid password
    When user clicks on login
    Then the product page should open

  Scenario: Login with invalid credentials
    Given user enters invalid username and invalid password
    When user clicks on login
    Then product page shouldn't open
    And error message is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with no credentials
    Given user doesn't enters username and password
    When user clicks on login
    Then product page doesn't open
    And error message is displayed "Epic sadface: Username is required"

  Scenario: Login with valid username and invalid password
    Given user enters valid username and invalid password
    When user clicks on login
    Then product page doesn't open
    And error message is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with invalid username and valid password
    Given user enters invalid username and valid password
    When user clicks on login
    Then product page doesn't open
    And error message is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with valid username and empty password
    Given user enters valid username and empty password
    When user clicks on login
    Then product page doesn't open
    And error message is displayed "Epic sadface: Password is required"

  Scenario: Login with empty username and valid password
    Given user enters empty username and valid password
    When user clicks on login
    Then product page doesn't open
    And error message is displayed "Epic sadface: Username is required"

  Scenario: Login with locked_out_user username
    Given user enters valid username as locked_out_user
    And user enters valid password as secret_sauce
    When user clicks on login
    Then the product page shouldn't open
    But error message is displayed "Epic sadface: Sorry, this user has been locked out."

#  Scenario: Login with wrong username
#    Given user wants to retype username
#    When user wants to press the x icon to delete
#    Then username should be deleted so that the user can rewrite
#    But doesn't work to delete the username