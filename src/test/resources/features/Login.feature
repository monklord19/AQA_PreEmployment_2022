@Smoke
Feature: Login

  @ValidLogin
  Scenario Outline: Login successful with valid credentials
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "<username>" and password as "<password>"
    And user clicks on login
    Then Home page opens

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @InvalidLogin
  Scenario: Login with invalid credentials
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard_user9" and password as "secret_sauceeee"
    And user clicks on login
    Then error message is displayed "Epic sadface: Username and password do not match any user in this service"

  @InvalidLogin
  Scenario: Login with valid username and blank password
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard_user" and password as ""
    And user clicks on login
    Then error message is displayed "Epic sadface: Password is required"

  @InvalidLogin
  Scenario: Login with blank username and valid password
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "" and password as "secret_sauce"
    And user clicks on login
    Then error message is displayed "Epic sadface: Username is required"

  @InvalidLogin
  Scenario: Login with blank credentials
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "" and password as ""
    And user clicks on login
    Then error message is displayed "Epic sadface: Username is required"

  @ValidLogin
  Scenario: Login by pressing Enter key
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard_user" and password as "secret_sauce"
    And user presses Enter key
    Then Home page opens


  Scenario: User successfully logged out
    Given user is logged in
    When user clicks on hamburger button
    And user clicks on Logout button
    Then Login page reopens

  Scenario: Logout and click on back button
    Given user is logged in
    When user signs out
    And user clicks on Go back button
    Then user remains on Login page
    But error message is displayed "Epic sadface: You can only access '/inventory.html' when you are logged in."


  Scenario: User successfully navigates to About page
    Given user is logged in
    When user clicks on About button
    Then About page opens



