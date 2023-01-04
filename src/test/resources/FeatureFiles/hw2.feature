Feature: Login testing

  @ValidLogin
  Scenario: Login using valid credentials
    Given On sauce website
    When User enters username
    And Password
    And Clicks the login button
    Then User should be logged in


  @InvalidLogin
  Scenario: Login using invalid credentials
    Given On sauce website2
    When User enters username2
    And Wrong password
    And Clicks the login button2
    Then User should not be logged in
