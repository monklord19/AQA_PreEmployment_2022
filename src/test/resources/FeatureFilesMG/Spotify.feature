Feature: Spotify login

  Background:
    Given User opens spotify site
    And User click on spotify LogIn button

  Scenario: Invalid log in with facebook account
    When User click on continue with facebook button
    And User enters a valid email as 'mada_lina430@yahoo.com' and invalid password as 'Test123'
    Then The error message is displayed 'The password you’ve entered is incorrect. Forgot Password?'

  Scenario: Invalid log in with google account
    When User click on continue with google button
    And User enters valid email as 'mada_lina430@yahoo.com'
    And user click on next button
    And User enters invalid password as 'youbetterworkthistime'
    And user click on next button
    Then error message is displayed 'Wrong password. Try again or click Forgot password to reset it.'

  Scenario: Invalid log in with spotify
    When User enters valid email as 'mada_lina430@yahoo.com' and invalid password as 'Test123'
    And user click on Login button
    Then error message appears 'Incorrect username or password.'


