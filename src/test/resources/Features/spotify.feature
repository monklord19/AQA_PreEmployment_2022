Feature: SpotifyLogin

  Background:
    Given I open spotify website

  @LoginWithEmailOrUsername
  Scenario: Try to login in spotify with google account
    When I accept cookies
    And I press home login button
    Then  I enter username "username" and password "password"
    And I press log in button
    Then I sould see the error "Incorrect username or password."

  @LogInWithAppleAccount
  Scenario: Try to login with apple account
    When I accept cookies
    And I press home login button
    And I chose to login with Apple
    When I add the apple id "username" and press enter key
    And i enter password "password" and press the enter key
    Then I shoud see the apple error message "This Apple ID has been locked for security reasons."

  @LoginWithGoogleAccount
  Scenario: Try to login with google account
    When I accept cookies
    And I press home login button
    And I chose to login with Google Account
    Then I enter email "username@yahoo.com" and press next button
    And I enter password "password" and press next button
    And I should see an error

  @LoginWithFacebookOnSpotify
  Scenario: Try to login with facebook account
    When I accept cookies
    And I press home login button
    And I chose to login with Facebook Account
    And I accept facebook cookies
    When I insert email "username@yahoo.com" and password "password"
    And I press Login Button
    Then I should see the error "The password you’ve entered is incorrect. Forgot Password?"

