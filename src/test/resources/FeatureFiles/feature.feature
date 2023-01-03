Feature: Homework week2 marti

  Scenario:
    Given On sauce website
    When User enters no credentials
    Then User shouldn't be logged in
    And display message "Epic sadface: Username is required"

  Scenario:
    Given On sauce website
    When user logging in using "random_user" and password as "secret_sauce"
    Then user shouldn't be able to log in
    And display "Epic sadface: Username and password do not match any user in this service"


