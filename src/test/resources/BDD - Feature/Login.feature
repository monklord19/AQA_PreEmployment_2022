Feature: Homework week 2 ~Tuesday~
  Background: Open the Login page "https://www.saucedemo.com/"

  Scenario: Login with valid credentials
    Given I type a valid username
    And I enter a valid password
      | username | password |
      | problem_user | secret_sauce|
    When I press the login button
    Then The login was successful

  Scenario: Login with invalid credentials
    Given I enter numbers as username
    And I enter numbers as password
      | username | password |
      | 1234 | 0987 |
    When I press the login button
    Then An error pop-up appears

  Scenario: Login leaving the fields blank
    Given I left the username field blank
    And I left the password field blank
      | username | password |
      |          |          |
    When I press the login button
    Then An error pop-up appears

  Scenario: Login leaving the username field blank
    Given I left the username field blank
    And I enter a valid password
      | username | password |
      |          | secret_sauce|
    When I press the login button
    Then An error pop-up appears

  Scenario: Login leaving the password field blank
    Given I enter a valid username
    And I left the password field blank
      | username | password |
      | problem_user |      |
    When I press the login button
    Then An error pop-up appears

  Scenario: Login with a different password
    Given I enter a valid username
    And I enter a different password
      | username | password |
      | problem_user | secret_santa |
    When I press the login button
    Then An error pop-up appears

  Scenario:  Login with capital letters
    Given I enter the username with capital letters
    And I enter the password with capital letters
      | username | password |
      | PROBLEM_USER | SECRET_SAUCE |
    When I press the login button
    Then An error pop-up appears

  Scenario: Login with special characters in the fields
    Given I enter special characters as username
    And I enter special characters as password
      | username | password |
      | *^$# | *^%$# |
    When I press the login button
    Then An error pop-up appears

  Scenario: Login with the copy-paste password
    Given I enter a valid username
    And I enter a copy-paste password
      | username | password |
      | problem_user | secret_sauce |
    When I press the login button
    Then The login was successful

