Feature: Logging in to https://open.spotify.com/

  Scenario: Log in with invalid Spotify credentials
    Given On the Spotify Login page
    When I enter invalid username and password
    And I click Log in button
    Then I am unable to log in and error message is displayed


