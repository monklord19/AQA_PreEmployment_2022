Feature: Login on Spotify

  Background:
    Given user is on the main page
    And user closes cookie
    And user goes to login page

  Scenario: user tries to login on Spotify with Gmail account
    When user clicks continue with Google
    And user enters 'test@test.com' characters in username field
    And user clicks on Gmail login button
    Then error message is displayed

  Scenario: user tries to login on Spotify with account
    When user enters 'test' in Spotify username field
    And user enters 'pass' in Spotify password field
    And user clicks on Spotify login button
    Then invalid username and password message is displayed