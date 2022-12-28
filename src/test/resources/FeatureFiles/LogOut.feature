Feature: Test logout functionality
  This feature deals with the logout functionality of the application
  Scenario: Check if a user is already logged in and loging out a user
    Given User is already loggin on site
    When  User clicks on log out button
    Then  User should be redirected to home page
