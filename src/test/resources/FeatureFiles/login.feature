Feature: Logging in to https://www.saucedemo.com/

  Background:
    Given I open https://www.saucedemo.com/

  Scenario: Log in with blank username and password
    When I click Login
    Then I am unable to log in
    And Error message is displayed "Epic sadface: Username is required"

  Scenario: Log in with blank username and valid password
    When I enter a valid password
    And I click Login
    Then I am unable to log in
    And Error message is displayed "Epic sadface: Username is required"

  Scenario: Log in with valid username and blank password
    When I enter a valid username
    And I click Login
    Then I am unable to log in
    And Error message is displayed "Epic sadface: Password is required"

  Scenario Outline: Log in with valid username and password
    When I enter a valid <userName> and <password>
    And I click Login
    Then I log in to Swag Labs
    Examples:
      | userName                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario: Log in with invalid username and password
    When I enter the "standard_use" username and "secret_sauce" password
    And I click Login
    Then I am unable to log in
    And Error message is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Log in with valid username and invalid password
    When I enter a valid username and an invalid password
    And I click Login
    Then I am unable to log in
    And Error message is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Log in using 'Tab' key to navigate and 'Enter' to log in
    When I use Tab to move focus to username field
    And I enter valid username
    And I use Tab to move focus to password field
    And I enter a valid password
    And I use Enter
    Then I am able to log in

  Scenario: Log in w/o credentials by using the 'Back' and 'Forward' buttons
    When I am logged in to https://www.saucedemo.com/
    And I return to the login page via the ‘Back' button of the browser
    And I use the 'Forward' button
    Then I am able to log in without adding my credentials

  Scenario: Log out of https://www.saucedemo.com/
     Given I am logged in to https://www.saucedemo.com/
     When I select LOGOUT from the hamburger menu list
     Then I am able to log out.

