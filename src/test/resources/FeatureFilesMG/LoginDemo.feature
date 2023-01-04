@Smoke
Feature: Login feature
  Background:
    Given User opens login page
  @ValidLogin
  Scenario Outline: Valid Username and Password

    When User input "<username>" and "<password>"
    And  User click on Login button
    Then User is successfully logged in
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @ValidLogin
  Scenario Outline: Successfully login with Enter key
    When User input "<username>" and "<password>"
    And Press Enter key
    Then User is successfully logged in
    Examples:
      |username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @InvalidLogin
  Scenario: Valid username and empty password
    When User input valid username as "standard_user" and blank password
    And User click on Login button
    Then User should not be logged and should see a popup as "Epic sadface: Password is required"


#
#  Scenario: Empty username and valid password
#    When User input username as "" and Password as "secret_sauce"
#    And User click on login button
#    Then User should not be logged in
#    And User should see a popup 'Epic sadface: username is required'
#
#  Scenario: Empty username and Password
#    When User click on Login button
#    Then User is not logged in
#    And User should see a popup 'Epic sadface: username is required'
#
#  Scenario Outline: Invalid login with capital letters
#    When User input valid <password> and <username> with capital letters
#    And User click on Login button
#    Then User should not be logged in
#    And User should see a popup 'Epic sadface: username and password do not match any user in this service'
#    Examples:
#      | username                | password     |
#      | STANDARD_USER           | SECRET_SAUCE |
#      | PROBLEM_USER            | SECRET_SAUCE |
#      | PERFORMANCE_GLITCH_USER | SECRET_SAUCE |
#
#  Scenario: Invalid login with invalid credentials
#    When User input User as "random_user" and Password as "random_password"
#    And User click on Login
#    Then User should not be able to log in
#    And User should see a popup 'Epic sadface: username and password do not match any user in this service'
#
#  Scenario: Locked out user and valid password
#    When User input username as "locked_out_user"
#    And Password as "secret_sauce"
#    Then User should not be logged in
#    And User should see a popup 'Epic sadface: Sorry, this user has been locked out.'
#
#  Scenario:refresh the page
#    When User input username and password
#    And User press refresh
#    Then username and password should not be stored into login page
#
#  Scenario: Verify that password can be displayed
#    Given User opens browser Microsoft Edge
#    And Go to the URL 'https://www.saucedemo.com/'
#    When User input valid username and password
#    And Click on 'eye' icon in the password field
#    Then Password should be displayed
#
#  @Performance
#  Scenario: User can quickly be logged in
#    When User input username as 'performance_user' and Password as 'secret_sauce'
#    And User click on Login button
#    Then User is successfully logged in
#    And User should have to wait no longer than the max acceptable wait time










