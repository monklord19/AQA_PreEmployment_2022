Feature: User Login

  Scenario: User is not able to login on Spotify
    Given User enters valid username in the username field
    And User enters invalid password in the password field
    When User clicks on the login button
    Then User is not logged in