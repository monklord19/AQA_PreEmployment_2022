Feature: Testing login page
  Background: I open login page at https://www.saucedemo.com/

  Scenario: Valid credentials login
    Given Open browser
    And I open login page
    When I enter username and password
    And    Click login button
    Then  Login successful, home page displayed

  Scenario: Invalid credentials login
    Given I open login page
    When  I enter invalid username and password
    And    Click login button
    Then  Error is displayed

  Scenario: Empty fields login
    Given I open login page
    When Leave empty username and password
    And  Click login button
    Then Field 'username' displays error
    And Field 'password' displays error

  Scenario: Empty username field login
    Given  I open login page
    When  I leave empty username
    And enter password password
    And    Click login button
    Then Field 'username' displays error

  Scenario: Empty password field login
    Given I open login page
    When  I enter valid username
    And leave empty password
    And    Click login button
    Then  Field 'password' displays error

  Scenario: Verify if password can be seen
    Given I open M. Edge browser
    And  I open login page
    When  I enter valid username and password
    And    Click 'eye' in password field
    Then Password is displayed

  Scenario: Verify if password is hidden
    Given I open login page
    When  I enter valid username and password
    Then  Password is displayed as bullets

  Scenario: Verify if the ‘Enter’ key of the keyboard is working
    Given  I open login page
    When  I enter username and password
    And   Press 'Enter' on keyboard
    Then   Login successful, home page displayed

