Feature: Login with Facebook


  Scenario: user tries to login with Facebook account on Spotify
    Given Open spotify login page
    When User clicks Continue with Facebook button
    And Facebook login page is displayed
    And User enters facebook username 'username'
    And User enters facebook password 'password'
    And User clicks on Facebook login button
    Then Spotify main page should be displayed