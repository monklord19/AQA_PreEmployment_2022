Feature: Test login functionality
  This feature deals with the login functionality of the application
  Scenario: Check login is successful with valid credentials

    Given User opens sauce demo site
    When User enters username
    And User types password
    And User clicks on login button
    Then User should be logged in
    And User should be loged out
    And If user types incorrect credentials
    And User clicks on login
    And User should receive an error message

#    Scenario Outline: Check login is sucessful with valid credentials
#      Given User open https://www.saucedemo.com/
#      When User enters "<username>"
#      And User types "<passsword>"
#      And User click on login button
#      Then User should be logged in

#    Examples:
#    |username             |passsword      |
#    |standard_user        |secret_sauce   |
