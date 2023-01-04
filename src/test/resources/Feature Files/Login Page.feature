Feature: Homework Week 2

  Scenario: Successful Login with valid credentials
    Given user enters valid username in the email field
    And user enters valid password in the password field
    When user clicks on the login button
    Then user is logged in successfully

  Scenario Outline:
    Given I open the https://www.saucedemo.com/ website
    When I enter the <userName> and <password>
    Then I should be able to  successfully login on the https://www.saucedemo.com/ website
    Examples:
      | userName                |  | password     |
      | standard_user           |  | secret_sauce |
      | locked_out_user         |  | secret_sauce |
      | problem_user            |  | secret_sauce |
      | performance_glitch_user |  | secret_sauce |


  Scenario Outline: Unsuccessful Login with Valid username and Invalid password
    Given I open the https://www.saucedemo.com/ website
    When I enter a valid <userName>
    And enter an invalid <password>
    Then I shouldn't be able to successfully login on the website
    Examples:
      | userName                |  | password          |
      | standard_user           |  | invalid.password1 |
      | locked_out_user         |  | !!!!!!!!!         |
      | problem_user            |  | INVALIDPASSWORD   |
      | performance_glitch_user |  | 74859387          |


  Scenario Outline: Unsuccessful Login with Invalid username and Valid password
    Given I open the https://www.saucedemo.com/ website
    When I enter a invalid <userName>
    And enter an valid <password>
    Then I shouldn't be able to successfully login on the website
    Examples:
      | userName         |  | password     |
      | invalid.username |  | secret_sauce |
      | INVALIDUSERNAME  |  | secret_sauce |
      | 11212333         |  | secret_sauce |
      | !@$%^&*(         |  | secret_sauce |


  Scenario Outline: Unsuccessful Login with Invalid entries
    Given I open the https://www.saucedemo.com/ website
    When I enter a invalid <userName>
    And enter an invalid <password>
    Then I shouldn't be able to successfully login on the website
    Examples:
      | userName         |  | password     |
      | invalid.username |  | secret_sauce_invalid |
      | INVALIDUSERNAME  |  | secret_sauce122 |
      | 11212333         |  | secret_sauce@@@ |
      | !@$%^&*(         |  | secret_sauceQQQ |


  Scenario Outline: Unsuccessful Login with invalid Email username and Valid password
    Given I open the https://www.saucedemo.com/ website
    When I enter a invalid <userName>
    And enter an valid <password>
    Then I shouldn't be able to successfully login on the website
    Examples:
      | userName                |  | password     |
      | standard_user@gmail.com |  | secret_sauce |
      | maniucalina@gmail.com   |  | secret_sauce |


  Scenario: Unsuccessful Login with Blank username and Valid password
    Given I open the https://www.saucedemo.com/ website
    When I don't enter a <userName>
    And enter an valid <password>
    Then I shouldn't be able to successfully login on the website


  Scenario: Unsuccessful Login with Valid username and Blank password
    Given I open the https://www.saucedemo.com/ website
    When I enter a valid <userName>
    And I don't enter a <password>
    Then I shouldn't be able to successfully login on the website


  Scenario: Unsuccessful Login with Blank entries
    Given I open the https://www.saucedemo.com/ website
    When I don't enter a <userName>
    And I don't enter a <password>
    Then I shouldn't be able to successfully login on the website

