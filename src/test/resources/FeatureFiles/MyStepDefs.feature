Feature: Homework

  Scenario: Valid username and password standard_user
    Given On sauce website
    When User enters valid credential "standard_user" and "secret_sauce"
    Then User should be logged with success "true"

  Scenario: Valid username and password locked_out_user
    Given On sauce website
    When User enters valid credential "locked_out_user" and "secret_sauce"
    Then User should be logged with success "false"

  Scenario: Valid username and password problem_user
    Given On sauce website
    When User enters valid credential "problem_user" and "secret_sauce"
    Then User should be logged with success "true"

  Scenario: Valid username and password performance_glitch_user
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and "secret_sauce"
    Then User should be logged with success "true"

  Scenario: Valid username and password empty_password
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and ""
    Then User should be logged with success "false"

  Scenario: Valid username and password wrong_password
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and "wrong_password"
    Then User should be logged with success "false"

  Scenario: Valid username and password empty_username
    Given On sauce website
    When User enters valid credential "" and "secret_sauce"
    Then User should be logged with success "false"

  Scenario: Valid username and password and long duration login
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and "secret_sauce"
    Then User should be logged with success "true"
    And Loading takes more then or equal to 5 seconds

  Scenario: Valid username and password and short duration login
    Given On sauce website
    When User enters valid credential "standard_user" and "secret_sauce"
    Then User should be logged with success "true"
    And Loading takes less then or equal to 2 seconds

  Scenario: Add product to cart
    Given On sauce website
    When User enters valid credential "problem_user" and "secret_sauce"
    And  User adds all products
    Then User goes to cart and has all products

  Scenario: Test Impressive Radio Button on DemoQa
    Given On demo website
    When User selects impressive radio button
    Then Check label is displayed correctly

  Scenario: Log in in Spotify website
    Given On spotify website
    When User enters credentials "email-test@gmail.com" and "password-test"
    Then User need to be logged in with success "false"

  Scenario: Log in Spotify website via google
    Given On spotify website
    When User goes to login with google
    And User enter valid google an email "google-test@gmail.com"
    Then User should allowed to enter password "false"


  Scenario: Log in Spotify website via apple
    Given On spotify website
    When User goes to login with apple
    And User enter apple id "9999@yahoo.ro"
    And User enter apple password "bbbb"
    Then User should be logged in with apple account "false"

  Scenario: Log in Spotify website via facebook
    Given On spotify website
    When User goes to login with facebook
    And Allow cookies
    And User enter facebook credentials "facebook-test@gmail.com" and "facebook-password-test"
    Then User should be logged in with facebook account "false"
    And Refresh page to try another password
    And Enter another facebook password "facebook-second-password-test"
    Then User should be logged in with facebook account "false"





