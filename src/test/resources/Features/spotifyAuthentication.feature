Feature: Spotify Authentication

  Scenario: Login with Google account
    Given On Spotify website
    When User clicks on Login button accounts page is displayed
    And User selects continue with Google, enters invalid mail and  invalid password
    Then User can not login and error message is displayed

    Scenario: Login with Spotify account
      Given On Spotify website
      When User clicks on Login button accounts page is displayed
      And User enters invalid mail and  invalid password for Spotify account
      Then User can not login and error message is displayed