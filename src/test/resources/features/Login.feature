Feature: Login

  Background:
    Given user navigates to https://www.saucedemo.com/

  @smoke
  Scenario Outline: Login successful with valid credentials
    When user enters username as "<username>" and password as "<password>"
    And user clicks on Login
    Then Home page opens

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |


  Scenario: Login with invalid credentials
    When user enters username as "standard_user9" and password as "secret_sauceeee"
    And user clicks on Login
    Then error message is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with valid username and blank password
    When user enters username as "standard_user" and password as ""
    And user clicks on login
    Then error message is displayed "Epic sadface: Password is required"

  Scenario: Login with blank username and valid password
    When user enters username as "" and password as "secret_sauce"
    And user clicks on login
    Then error message is displayed "Epic sadface: Username is required"

  Scenario: Login with blank credentials
    When user enters username as "" and password as ""
    And user clicks on login
    Then error message is displayed "Epic sadface: Username is required"

  Scenario: Login by pressing Enter key
    When user enters username as "standard_user" and password as "secret_sauce"
    And user presses Enter key
    Then Home page opens

  @smoke
  Scenario: User successfully logged out
    When user enters username as "standard_user" and password as "secret_sauce"
    And user clicks on login
    Then Home page opens
    When user clicks on hamburger button
    And user clicks on Logout button
    Then Login page reopens

  Scenario: Logout and click on back button
    When user enters username as "standard_user" and password as "secret_sauce"
    And user clicks on login
    Then Home page opens
    When user clicks on hamburger button
    And user clicks on Logout button
    Then Login page reopens
    When user clicks on Go back button
    Then user remains on Login page
    But error message is displayed "Epic sadface: You can only access '/inventory.html' when you are logged in."






