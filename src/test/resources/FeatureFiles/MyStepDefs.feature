Feature: Homework Week2 - Tuesday

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
