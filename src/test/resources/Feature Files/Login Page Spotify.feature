Feature: User Login

  Scenario: User is not able to login on Spotify with Email address or username
    Given User enters valid username in the username field
    And User enters invalid password in the password field
    When User clicks on the login button
    Then User is not logged in


  Scenario: User is not able to login on Spotify using the button "Continue with Google"
    Given User clicks the button "Continue with Google" on the Login page
    And User selects the option "Use another account"
    When User enters valid email address in the 'Email or phone' field
    And User enters invalid password in the 'Enter your password' field
    Then User is not logged in