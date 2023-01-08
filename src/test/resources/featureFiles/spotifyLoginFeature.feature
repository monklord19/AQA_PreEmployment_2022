Feature: Login on Spotify

  Background:
    Given user is on the main page
    And user closes cookie
    And user goes to login page

  Scenario: user tries to login on Spotify with Gmail account
    When user clicks continue with Google
    And user enters 'angmailaccount@gmail.com' characters in username field
    And user clicks on Gmail login button
    Then error message is displayed

  Scenario: user tries to login on Spotify with account
    When user enters 'anspotifyaccount' in Spotify username field
    And user enters 'password' in Spotify password field
    And user clicks on Spotify login button
    Then message is displayed: 'Incorrect username or password.'