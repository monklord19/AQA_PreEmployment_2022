Feature: User Login

  Scenario: User is not able to login on Spotify with Email address or username
    Given User enters valid username in the username field
    And User enters invalid password in the password field
    When User clicks on the login button
    Then Login is unsuccessfully


  Scenario: User is not able to login on Spotify using the button "Continue with Google"
    Given User clicks the button CONTINUE WITH GOOGLE on the Login page
    And User selects the option USE ANOTHER ACCOUNT
    When User enters valid email address in the EMAIL OR PHONE field
    And User enters invalid password in the ENTER YOUR PASSWORD field
gv