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
    Then inccorect username and password message is displayed

  Scenario: user tries to login on Spotify with Facebook account
    When user click continue with Facebook
    And user accept cookies
    And user enters 'username' in Facebook username field
    And user enters 'password' in Facebook password field
    And user clicks on Facebook login button
    Then not account message is displayed

  Scenario: user tries to login on Spotify with Apple account
    When user click continue with Apple
    And user enters 'appleusername' in Apple username field
    And user clicks submit button
    And user enters 'applepassword' in Apple password field
    And user clicks submit button
    And user get alert message
    And error message is: 'This Apple ID has been locked for security reasons.'
