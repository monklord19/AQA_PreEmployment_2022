Feature: Spotify Login

  @InvalidLogin
  Scenario: Login with incorrect spotify credintials
    Given user gets to "https://open.spotify.com/"
    And user accepts cookies
    And user click on Log in button
    Then user enter username as "adelin" and password as "moldovan"
    And user click Log in with Spotify
    Then pop up appears containing"Incorrect username or password."

  @InvalidLogin
  Scenario: Login with google account and invalid google credentials
    Given user gets to "https://open.spotify.com/"
    And user accepts cookies
    And user click on Log in button
    When user click on Continue with Google button
    And user enters emailAdress as "adelin" and password as "moldovan"
    And user click on Login with google
    Then pop up appears "The password is wrong. Try again or click Forgot your password? to reset it."