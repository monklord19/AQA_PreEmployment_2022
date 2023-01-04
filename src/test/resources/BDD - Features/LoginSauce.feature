@Login
Feature: Login
  as user i want to login to sauce demo

  Scenario: Normal Login
    Given user open the web page
    When user input "standard_user" as userName and "secret_sauce" as password
    Then user already go to inventory page


  Scenario Outline: Invalid Login
    Given user open the web page
    When user input "<userName>" as userName and "<password>" as password
    Then user will get "<errorText>" on login page
    Examples:
      | userName      | password     | errorText                                                                 |
      | asd           | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user | 123          | Epic sadface: Username and password do not match any user in this service |
      | asd           | asd          | Epic sadface: Username and password do not match any user in this service |