@Smoke
Feature: Log-in

  @InValidLogin
  Scenario: Sign-in with invalid username and wrong password
    Given User is on Spotify page
    And User accepts cookies
    And User clicks on Connect button
    When User enters mail
    And User enters password
    And User clicks on login button
    Then User is not logged in