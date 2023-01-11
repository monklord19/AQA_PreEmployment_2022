Feature: User Login

  Scenario: User is not able to login on Spotify with Email address or username
    Given User enters valid username in the username field
    And User enters invalid password in the password field
    When User clicks on the login button
    Then Login can't log in


  Scenario: User is not able to login on Spotify using the button "Continue with Google"
    Given User clicks the button CONTINUE WITH GOOGLE on the Login page
    And User selects the option USE ANOTHER ACCOUNT
    When User enters valid email address in the EMAIL OR PHONE field
    And User enters invalid password in the ENTER YOUR PASSWORD field
    Then user is not logged in


  Scenario: User is not able to login on Spotify using the button "Continue with Apple"
    Given User clicks the button CONTINUE WITH APPLE on the Login page
    When User enters valid Appple ID in the Apple ID field
    And User enters invalid password in the PASSWORD field
    Then User cannot login on Spotify