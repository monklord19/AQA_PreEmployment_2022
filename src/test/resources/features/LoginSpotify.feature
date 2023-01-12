Feature: Login

  @InvalidLogin
  Scenario: Login with invalid credentials on Spotify
    Given user navigates to Spotify "https://open.spotify.com/"
    And user clicks on Log in
    When user enters for Spotify username as "ddd@gmail.com" and password as "secret"
    And user clicks on Spotify login
    Then Spotify error message is displayed "Incorrect username or password."

  @InvalidLogin
  Scenario: Login with invalid gmail on Spotify using continue with apple
    Given user navigates to Spotify "https://open.spotify.com/"
    And user clicks on Log in
    When user clicks on Continue with Apple
    And user enters for appleId as "dian4ik171717@gmail.com" and password as "secret"
    Then error message appears "Your Apple ID or password was incorrect."