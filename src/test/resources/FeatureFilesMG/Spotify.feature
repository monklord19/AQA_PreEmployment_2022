Feature: Spotify login

  Background:
    Given User opens spotify site
    And User click on spotify LogIn button

  Scenario: Invalid log in with facebook account
    When User click on continue with facebook button
    And User enters a valid email and invalid password
    Then An error message is displayed

  Scenario: Invalid log in with google account
    When User click on continue with google button
    And User enters valid email
    And user click on next button
    And User enters invalid password
    And user click on next button
    Then error message is displayed

  Scenario: Invalid log in with spotify
    When User enters valid email and invalid password
    And user click on Login button
    Then error message appears

  Scenario: Invalid login with apple
    When User click on continue with apple
    And User fill in the Apple ID
    And User click next arrow
    And User fill in the password field
    And User click next arrow
    Then User is not logged and error is displayed


