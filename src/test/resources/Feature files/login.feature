Feature: Login feature

  Background:
  Given User opens URL 'https://www.saucedemo.com/'
  @ValidLogin
  Scenario Outline: Valid username and password
    When User input <Username> and <Password>
    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
    And User click on Login button
    Then User is successfully logged in

  Scenario: login with enter key
    When User inputs valid Username and Password
    And Press Enter key
    Then User is successfully logged in

  @InvalidLogin
  Scenario Outline: valid username and empty password
    When User input valid <Username>
    Examples:
      | Username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
    And Leave the password field empty
    And User click on Login button
    Then User should not be logged in
    And User should see a popup 'Epic sadface: Password is required'

  Scenario: empty username and valid password
    When User leave the Username empty
    And User input valid <Password>
    And User click on login button
    Then User should not be logged in
    And User should see a popup 'Epic sadface: Username is required'

  Scenario: empty username and password
    When User click on Login button
    Then User is not logged in
    And User should see a popup 'Epic sadface: Username is required'

  Scenario: invalid login with capital letters
    When User input valid password and username with capital letters
    And User click on Login button
    Then User should not be logged in
    And User should see a popup 'Epic sadface: Username and password do not match any user in this service'

  Scenario Outline: login with invalid credentials
    When User input invalid <Username> and <Password>
    Examples:
      | Username    | Password        |
      | random_user | random_password |
    And User click on Login
    Then User should not be able to log in
    And User should see a popup 'Epic sadface: Username and password do not match any user in this service'

  Scenario: Locked out user and valid password
    When User input Username as 'locked_out_user'
    And Password as 'secret_sauce'
    Then User should not be logged in
    And User should see a popup 'Epic sadface: Sorry, this user has been locked out.'

  Scenario:refresh the page
    When User input username and password
    And User press refresh
    Then Username and password should not be stored into login page

  Scenario: Verify that password can be displayed
    Given User open browser Microsoft Edge
    And Go to the URL 'https://www.saucedemo.com/'
    When User input valid username and password
    And Click on 'eye' icon in the password field
    Then The password should be displayed

  @Performance
  Scenario: user can quickly be logged in
    Given User opens URL 'https://www.saucedemo.com/'
    When User input password as 'performance_user' and password as 'secret_sauce'
    And User click on Login button
    Then User should be logged in
    And User should have to wait no longer than the max acceptable wait time