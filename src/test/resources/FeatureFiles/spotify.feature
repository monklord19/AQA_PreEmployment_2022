Feature: Login into spotify using 2 types of login

  @LoginUsingSpotifyAcc
  Scenario: Login into Spotify
    Given User is on spotify homepage
#    When The user clicks on the accept cookies button
#    And Clicks on the Log In button
    And User enters username
    And User enters password
    And Clicks the Log in button
    Then User should get an error message

  @LoginUsingAppleAcc
  Scenario: Login into Spotify with Apple
    Given User is on spotify homepage
#      When The user clicks on the accept cookies button
#      And Clicks on the Log In button
    And Click on the Apple button
    And User enters email
    And Clicks the arrow button
    And User enters Apple password
    And Clicks the arrow button
    Then User should get an apple id error message



