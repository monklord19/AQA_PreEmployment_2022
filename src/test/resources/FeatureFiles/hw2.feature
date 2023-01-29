Feature: Login testing

  @ValidLogin
  Scenario Outline: Login using valid credentials
    Given On sauce website
    When User enters <username> and <password>
    And Clicks the login button
    Then User should be logged in

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |


  @InvalidLogin
  Scenario: Login using invalid credentials
    Given On sauce website
    When User enters username as "standard_user"
    And Password as "wrong"
    And Clicks the login button
    Then An error message is displayed "Epic sadface: Username and password do not match any user in this service"


  @Product
  Scenario: Adding a product to cart
    Given On sauce website
    When User enters username as "standard_user"
    And Password "secret_sauce"
    And Clicks the login button
    When Add to cart Sauce Labs Bike Light
    And I check the cart
    Then The item should be there

  @MultipleLogin
  Scenario Outline: Login using different usernames
    Given On sauce website
    When User enters username as "<username>"
    And Password as "<password>"
    And Clicks the login button
    Then User should be logged in

    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | problem_user    | secret_sauce |
      | locked_out_user | secret_sauce |


#  @RadioButton
#  Scenario: Check radio button
#    Given On demo site
#    When User selects Impressive radio button
#    Then Check label is displayed correctly