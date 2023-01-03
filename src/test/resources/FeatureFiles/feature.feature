Feature: Homework Week2 - Tuesday

  Scenario: Valid username and password
    Given I access https://www.saucedemo.com/
    When I login with username: |standard_user| and password: |secret_sauce|
    Then I am successfully logged in. Pop-up: Change your password

  Scenario: Valid username and password
    Given I access https://www.saucedemo.com/
    When I login with username:|locked_out_user| and password: |secret_sauce|
    Then Failed with error msg: Epic sadface: Sorry, this user has been locked out.

  Scenario Valid username and password
    Given I access https://www.saucedemo.com/
    When I login with username: |problem_user| and password: |secret_sauce| Successfull.
    Then I am successfully logged in. Pop-up: Change your password

  Scenario Valid username and password
    Given I access https://www.saucedemo.com/
    When I login with username: |performance_glitch_user| and password: |secret_sauce| Successfull.
    Then I am successfully logged in.

  Scenario: Empty password
    Given I access https://www.saucedemo.com/
    When I login with username: |standard_user| |locked_out_user| |problem_user| |performance_glitch_user|	password: |secret_sauce|
    Then Failed with error: Epic sadface: Password is required

  Scenario: Wrong password
    Given I access https://www.saucedemo.com/
    When I login with username: |standard_user| |locked_out_user| |problem_user| |performance_glitch_user|	password: |1234|
    Then Failed with error: Epic sadface: Username and password do not match any user in this service

  Scenario: Empty username
    Given I access https://www.saucedemo.com/
    When I login with username: |""|	password: |secret_sauce|
    Then Failed with error: Epic sadface: Username is required

  Scenario: Valid username and password
    Given I access https://www.saucedemo.com/
    When I login with username: |performance_glitch_user| and password: |secret_sauce|
    Then Page load time it is increased. Duration: 5,016 ms

