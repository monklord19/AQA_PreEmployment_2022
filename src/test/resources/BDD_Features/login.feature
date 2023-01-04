Feature: homework week 2

  Background:
    Given open the loginPage

  @ValidLogin
  Scenario Outline: Valid login into the page
    When I type the username "<username>" and the password "<password>"
    And  I click on login
    Then I should be logged in
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @InvalidLogin
  Scenario: The username does not belong in the list of valid usernames
    When I type the username "_user" and the password "secret_sauce"
    And  I click on login
    Then  A pop-up saying "Epic sadface: Username and password do not match any user in this service" should appear



  @InvalidLogin
  Scenario: The password does not correspond to the username
    When I type the username "problem_user" and the password "_password"
    And  I click on login
    Then  A pop-up saying "Epic sadface: Username and password do not match any user in this service" should appear


  @InvalidLogin
  Scenario: Both,the username and the password are not valid inputs
    When I type the username "_user" and the password "_password"
    And  I click on login
    Then  A pop-up saying "Epic sadface: Username and password do not match any user in this service" should appear


  @InvalidLogin
  Scenario: The inputs for username and password are empty
    When I type the username "" and the password ""
    And  I click on login
    Then  A pop-up saying "Epic sadface: Username is required" should appear


  @InvalidLogin
  Scenario: There is no value in the username field
    When I type the username "" and the password "secret_sauce"
    And  I click on login
    Then A pop-up saying "Epic sadface: Username is required" should appear


  @InvalidLogin
  Scenario: There is no value in the password field
    When I type the username "problem_user" and the password ""
    And  I click on login
    Then  A pop-up saying "Epic sadface: Password is required" should appear


  Scenario: There is a value in the username field and the page is refreshed
    When I type the username "_user" and the password ""
    And  I press the refresh button of the webpage
    And  I click on login
    Then A pop-up saying "Epic sadface: Username is required" should appear

  Scenario: There are values in the username field and in the password field and the page is refreshed
    When I type the username "problem_user" and the password "_password"
    And  I press the refresh button of the webpage
    And  I click on login
    Then A pop-up saying "Epic sadface: Username is required" should appear


