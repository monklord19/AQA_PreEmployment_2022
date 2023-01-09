Feature:Test Spotify Login
Background: I am on login page and accept coockies
@LoginwithGoogle
  Scenario: Login with Google account
    Given Click Connect
    And Choose CONTINUE WITH GOOGLE
    When Enter email "abc@abc.com"
    And Click Next
    Then Error Message is displayed

  @LoginwithSpotify
  Scenario:Login with Spotify account
    Given Click Connect
    When I enter abc@abc.com  and 123
    And Click LOGIN
    Then Error message2 is displayed

  @LoginwithApple
  Scenario: Login with Apple account
    Given Click Connect
    And Choose CONTINUE WITH Apple
    When Enter apple username "abc@abc.com"
    And Click Signin
    And Enter apple password "123"
    And Click Signin
    Then Error Message3 is displayed