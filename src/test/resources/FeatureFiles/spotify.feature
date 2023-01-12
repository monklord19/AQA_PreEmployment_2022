Feature:Test Spotify Login
Background: I am on login page and accept coockies
@LoginwithGoogle
  Scenario: Login with Google account
    Given Click Connect
    And Choose CONTINUE WITH GOOGLE
    When Enter "email"
    And Click Next
    Then Error Message is displayed

  @LoginwithSpotify
  Scenario:Login with Spotify account
    Given Click Connect
    When I enter username and password
    And Click LOGIN
    Then Error message2 is displayed

  @LoginwithApple
  Scenario: Login with Apple account
    Given Click Connect
    And Choose CONTINUE WITH Apple
    When Enter apple "username" first
    And Click Signin
    And Enter apple "password" second
    And Click Signin
    Then Error Message3 is displayed

  @LoginwithFacebook
  Scenario: Login with Facebook account
    Given Click Connect
    And Choose CONTINUE WITH Facebook
    And Close Facebook Cookies
   When Enter facebook "email" first
    And Enter facebook "password" second
    And Click login facebook
    Then Error Message Facebook is displayed