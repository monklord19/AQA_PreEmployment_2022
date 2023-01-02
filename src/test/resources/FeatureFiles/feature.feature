Feature: Homework week 2 ~Tuesday~
  Background: Open the Login page "https://www.saucedemo.com/"

  Scenario: Login with valid credentials
    Given On sauce website
    And User type a valid username
    And User enter a valid password
    When User press the login button
    Then The login was successful
  Example:
  | username        | password     |
  | standard_user   | secret_sauce |

  Scenario: Login with invalid credentials
    Given Open the page
    And User enter numbers as username
    And User enter numbers as password
    When User click the login button
    Then An error pop-up appears
  Example:
  | username | password |
  | 1234     | 0987     |

  Scenario: Login with a different password
    Given Open the sauce page
    And I enter a valid username
    And I enter a different password
    When Click on login button
    Then An error message appears
    Example:
      | username | password |
      | problem_user | secret_santa |

   Scenario:  Login with capital letters
    Given Open the web page
    Given I enter the username with capital letters
    And I enter the password with capital letters
    When Click the login button
    Then Error pop-up appears
    Example:
      | username | password |
      | PROBLEM_USER | SECRET_SAUCE |

  Scenario: Login with special characters in the fields
    Given User open the sauce page
    And User enter special characters as username
    And User enter special characters as password
    When User click on login button
    Then Error message appears
    Example:
      | username | password |
      | *^$# | *^%$# |