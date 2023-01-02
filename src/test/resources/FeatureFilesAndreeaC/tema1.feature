Feature: Testing login page
#  Background: I open login page at https://www.saucedemo.com/

  Scenario Outline: Valid credentials login
    Given I open login page
    When I enter <user> and <pass>
    And Click login button
    Then Login successful, home page displayed
    Examples:
    | user | pass |
    | standard_user|   secret_sauce  |
    | standard    |  sauce        |
    |             |  secret_sauce          |
    |  standard_user  |               |



