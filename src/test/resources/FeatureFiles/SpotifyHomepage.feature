Feature: Accessing Spotify login page from the Spotify homepage

  Scenario: Access Spotify login page
    Given On the Spotify site
    And I click ACCEPT COOKIES
    When I click Log in
    Then The Login - Spotify page opens