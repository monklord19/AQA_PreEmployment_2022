Feature: Login Page Test
  Background:
    Given user is on the login page "https://www.saucedemo.com/"
  Scenario Outline: Valid username and password
    When user enters valid username and password
    And clicks on login button
    Then user should be able to login
    Examples:
      |         username        |   password   |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
  Scenario: Blank username and password
    When user don't enters any username and password
    And clicks on login button
    Then user gets this message "Epic sadface: Username is required"
    And user should not be able to login
  Scenario: Blank username and password fields
    When user don't enters any username and password
    And clicks on login button
    Then user gets this message "Epic sadface: Username is required"
    And user should not be able to login
  Scenario: Invalid username and password
    When user enters invalid username and password
    And clicks on login button
    Then user gets this message "Epic sadface: Username and password do not match any user in this service"
    And user should not be able to login
  Scenario: Valid username and invalid password
    When user enters valid username and invalid password
    And clicks on login button
    Then user gets this message "Epic sadface: Username and password do not match any user in this service"
    And user should not be able to login
  Scenario: Invalid username and valid password
    When user enters invalid username and valid password
    And clicks on login button
    Then user gets this message "Epic sadface: Username and password do not match any user in this service"
    And user should not be able to login
  Scenario: Valid username and blank password
    When user enters valid username and no password
    And clicks on login button
    Then user gets this message "Epic sadface: Password is required"
    And user should not be able to login
  Scenario: Blank username and valid password
    When user enters blank username and valid password
    And clicks on login button
    Then user gets this message "Epic sadface: Username is required"
    And user should not be able to login

