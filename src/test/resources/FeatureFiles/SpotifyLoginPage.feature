Feature: Logging in to https://open.spotify.com/

  Scenario: Log in with invalid Spotify credentials
    Given On the Spotify site, I click ACCEPT COOKIES
    And I click Log in; the Login - Spotify page opens
    When I enter invalid username and password and I click LOG IN
    Then I am unable to log in and error message is displayed

  Scenario: Log in with invalid Google credentials
    Given On the Spotify site, I click ACCEPT COOKIES
    And I click Log in; the Login - Spotify page opens
    And I click CONTINUE WITH GOOGLE
    When I enter invalid username and click Inainte
    Then I am unable to log in and error message is displayed