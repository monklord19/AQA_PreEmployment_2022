Feature: Spotify Login


  Scenario: LoginSpotify with  invalid credentials gmail account
    Given user navigates to Spotify "https://open.spotify.com/"
    And  user clicks on Log in
    When user enters Spotify username "test@gmail.com " and password  as "a123"
    And clicks on Spotify login
    Then Spotify error message is displayed "Incorrect username or password"

  Scenario: Login with Apple account
    Given user navigates to Spotify "https://open.spotify.com/"
    And user clicks on Log in
    And user clicks on Continue with Apple
    When Enter apple id "test@test.com" and Click AppleSignin
    And Enter apple password "testing123"
    And Click AppleSignin
    Then Apple Error Message is displayed



  Scenario: Invalid login on facebook
    Given user navigates to Spotify "https://open.spotify.com/"
    And user clicks on Log in
    And Click continue with Facebook
    When Click on allow cookies
    And Enter Invalid username"test@test.com" and invalid password"testing123"
    And Click connect button
    Then Check to see if error is displayed