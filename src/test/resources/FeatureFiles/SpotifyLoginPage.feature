Feature: Logging in to https://open.spotify.com/

  Scenario: Log in with invalid Spotify credentials
    Given On the Spotify Login page
    When I enter invalid username and password
    And I click Log in button
    Then I am unable to log in and error message is displayed

  Scenario: Continue with Facebook
    Given On the Spotify Login page
    When I click Continue with Facebook
   Then The Facebook login page opens

  Scenario: Continue with Apple
    Given On the Spotify Login page
    When I click Continue with Apple
    Then The Apple login page opens

  Scenario: Continue with Google
    Given On the Spotify Login page
    When I click Continue with Google
    Then The Google login page opens


