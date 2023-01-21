Feature:Test Spotify Login
Background:I am on login page and accept coockies
@Test
  Scenario: Login with Google account
    Given Click Connect
    And Choose CONTINUE WITH GOOGLE
    When Enter "email"
    And Click Next
    Then Google Error Message is displayed

  @Test
  Scenario:Login with Spotify account
    Given Click Connect
    When I type credentials username and password
    And Click LOGIN
    Then Error message2 is displayed

  @Test
  Scenario: Login with Apple account
    Given Click Connect
    And Choose CONTINUE WITH Apple
    When Enter apple "username" first
    And Click Signin
    And Enter apple "password" second
    And Click Signin
    Then Error Message3 is displayed

  @Test
  Scenario: Login with Facebook account
    Given Click Connect
    And Choose CONTINUE WITH Facebook
    And Close Facebook Cookies
   When Enter facebook "email" first
    And Enter facebook "password" second
    And Click login facebook
    Then Error Message Facebook is displayed