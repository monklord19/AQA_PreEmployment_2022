Feature: Login feature
  Background: I am on login page

  Scenario Outline: Login with valid credentials
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters valid username "<username>" and valid password "<password>"
    And User clicks on Login button
    Then Login successful
    But locked_out_user should not be able to login on the website
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario: Login with partially valid credentials
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters partially valid username "standard_user7" and partially valid password "secret_sauce7"
    And User clicks on Login button
    Then User can`t login and error message is displayed

  Scenario Outline: Login with valid username and partially valid password
    Given I enter valid "<username>" and I add a random number to a valid "<password>"
    When I click on Login button
    Then User can`t login and Error message is displayed
    Examples:
      | username                | password      |
      | standard_user           | secret_sauce7 |
      | locked_out_user         | secret_sauce7 |
      | problem_user            | secret_sauce7 |
      | performance_glitch_user | secret_sauce7 |

  Scenario Outline: Login with valid username and blank password
    Given I enter valid "<username>" and I leave "<password>" field blank
    When I click on Login button
    Then User can`t login and Error message is displayed
    Examples:
      | username                | password |
      | standard_user           |          |
      | locked_out_user         |          |
      | problem_user            |          |
      | performance_glitch_user |          |

  Scenario Outline: Login with invalid username and valid password
    Given I add a random number to a valid "<username>" and I enter valid "<password>"
    When I click on Login button
    Then User can`t login and Error message is displayed
    Examples:
      | username                 | password     |
      | standard_user7           | secret_sauce |
      | locked_out_user7         | secret_sauce |
      | problem_user7            | secret_sauce |
      | performance_glitch_user7 | secret_sauce |

  Scenario Outline: Login with invalid username and blank password
    Given I add a random number to a valid "<username>" and I leave "<password>" field blank
    When I click on Login button
    Then User can`t login and Error message is displayed
    Examples:
      | username                 | password |
      | standard_user7           |          |
      | locked_out_user7         |          |
      | problem_user7            |          |
      | performance_glitch_user7 |          |

  Scenario: Login with valid username with a blank space suffix and valid password
    Given I enter valid username with a blank space suffix and I enter valid password
    When I click on Login button
    Then User can`t login and Error message is displayed

  Scenario: Login with valid username and a valid password with a blank space suffix
    Given I enter valid username and I enter valid password with a blank space suffix
    When I click on Login button
    Then User can`t login and Error message is displayed

  Scenario: Login with blank username and valid password
    Given I leave username field blank and I enter valid password
    When I click on Login button
    Then User can`t login and Error message is displayed

  Scenario: Login with blank username and invalid password
    Given I leave username field blank and I add a random number to a valid password
    When I click on Login button
    Then User can`t login and Error message is displayed

  Scenario: Login with blank username and blank password
    Given I leave username field blank and I leave password field blank
    When I click on Login button
    Then User can`t login and Error message is displayed









