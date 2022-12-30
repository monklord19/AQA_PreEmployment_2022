Feature: Testing login page

  Background: I open the  login page

  Scenario: Valid login into the page
    Given I go to "https://www.saucedemo.com/"
    When I type username as "standard_user" and I type password  as "secret_sauce"
    And I click on login
    Then I should be logged in

  Scenario: Refresh the page
    Given I enter the username
    When i click on refresh button
    Then page should be refreshed

  Scenario: Invalid login with number characters on username

    Given I go to "https://www.saucedemo.com/"
    When I type username as "12345" and I type password  as ""
    And I click on login
    Then login shouldn't work

  Scenario: Invalid login with white spaces
    Given I don't enter anything on username
    And i don't enter anything on password
    When I press the login button
    Then an error pop-up is displayed

  Scenario: Invalid login with wrong credentials
    Given I write wrong credentials
    When I press the login button
    Then an error pop-up is displayed "Username and password do not match"

  Scenario: Login with valid username and blank password
    Given valid username as standard user and blank password
    When I click on login
    Then error message is displayed "Password required"