@Smoke
Feature: Login functionality
  This feature deals with login functionality of saucedemo site
  Background: I open login page on https://www.saucedemo.com/

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
  Scenario Outline: Login failed with invalid credentials
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "<username>" and password as "<password>"
    And user clicks on login
    Then Error message is displayed

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce1 |
      | problem_user            | secret_sauce2 |
      | performance_glitch_user | secret_sauce3 |




  @InvalidLogin
  Scenario Outline: Login with valid username and blank password
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "<username>" and password as "<password>"
    And user clicks on login
    Then error message is displayed "Epic sadface: Password is required"

  Examples:

  |username                 |password |
  |standard_user            |         |
  |locked_out_user          |         |
  |problem_user             |         |
  |performance_glitch_user  |         |

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
    And user hits RETURN/ENTER key
    Then Home page opens


