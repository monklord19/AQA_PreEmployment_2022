Feature: Login feature

  Scenario Outline: Login with valid credentials
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters valid username "<username>" and valid password "<password>"
    And User clicks on Login button
    Then locked_out_user should not be able to login on the website and error message "<errorMessage>" is displayed
    Examples:
      | username                | password     |errorMessage                                       |
      | standard_user           | secret_sauce |                                                   |
      | locked_out_user         | secret_sauce |Epic sadface: Sorry, this user has been locked out.|
      | problem_user            | secret_sauce |                                                   |
      | performance_glitch_user | secret_sauce |                                                   |

  Scenario Outline: Login with partially valid credentials
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters partially valid username "standard_user7" and partially valid password "secret_sauce7"
    And User clicks on Login button
    Then User can`t login and error message "<errorMessage>" is displayed
    Examples:
      | errorMessage                                                              |
      | Epic sadface: Username and password do not match any user in this service |

  Scenario Outline: Login with valid username and partially valid password
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters valid username "<username>" and adds a random number to a valid password "<password>"
    And User clicks on Login button
    Then User can`t login and error message "<errorMessage>" is displayed
    Examples:
      | username                | password      | errorMessage                                                              |
      | standard_user           | secret_sauce7 | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user         | secret_sauce7 | Epic sadface: Username and password do not match any user in this service |
      | problem_user            | secret_sauce7 | Epic sadface: Username and password do not match any user in this service |
      | performance_glitch_user | secret_sauce7 | Epic sadface: Username and password do not match any user in this service |

  Scenario Outline: Login with valid username and blank password
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters valid username "<username>" and leaves password "<password>" field blank
    And User clicks on Login button
    Then User can`t login and error message "<errorMessage>" is displayed
    Examples:
      | username                | password | errorMessage                       |
      | standard_user           |          | Epic sadface: Password is required |
      | locked_out_user         |          | Epic sadface: Password is required |
      | problem_user            |          | Epic sadface: Password is required |
      | performance_glitch_user |          | Epic sadface: Password is required |

  Scenario Outline: Login with invalid username and valid password
    Given User navigates to website "https://www.saucedemo.com/"
    When User adds a random number to a valid username "<username>" and enters valid password "<password>"
    And User clicks on Login button
    Then User can`t login and error message "<errorMessage>" is displayed
    Examples:
      | username                 | password     |errorMessage                                                             |
      | standard_user7           | secret_sauce |Epic sadface: Username and password do not match any user in this service|
      | locked_out_user7         | secret_sauce |Epic sadface: Username and password do not match any user in this service|
      | problem_user7            | secret_sauce |Epic sadface: Username and password do not match any user in this service|
      | performance_glitch_user7 | secret_sauce |Epic sadface: Username and password do not match any user in this service|

  Scenario Outline: Login with invalid username and blank password
    Given User navigates to website "https://www.saucedemo.com/"
    When User adds a random number to a valid username "<username>" and leaves password "<password>" field blank
    And User clicks on Login button
    Then User can`t login and error message "<errorMessage>" is displayed
    Examples:
      | username                 | password |errorMessage                      |
      | standard_user7           |          |Epic sadface: Password is required|
      | locked_out_user7         |          |Epic sadface: Password is required|
      | problem_user7            |          |Epic sadface: Password is required|
      | performance_glitch_user7 |          |Epic sadface: Password is required|

  Scenario: Login with valid username with a blank space suffix and valid password
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters valid username "standard_user " with a blank space suffix and enters valid password "secret_sauce"
    And User clicks on Login button
    Then User can`t login and error message "Epic sadface: Username and password do not match any user in this service" is displayed

  Scenario: Login with valid username and a valid password with a blank space suffix
    Given User navigates to website "https://www.saucedemo.com/"
    When User enters valid username "standard_user" and enters valid password "secret_sauce " with a blank space suffix
    And User clicks on Login button
    Then User can`t login and error message "Epic sadface: Username and password do not match any user in this service" is displayed

  Scenario: Login with blank username and valid password
    Given User navigates to website "https://www.saucedemo.com/"
    When User leaves username field blank "" and enters valid password "secret_sauce"
    And User clicks on Login button
    Then User can`t login and error message "Epic sadface: Username is required" is displayed

  Scenario: Login with blank username and invalid password
    Given User navigates to website "https://www.saucedemo.com/"
    When User leaves username field blank "" and enters invalid password "secret_sauce7"
    And User clicks on Login button
    Then User can`t login and error message "Epic sadface: Username is required" is displayed

  Scenario: Login with blank username and blank password
    Given User navigates to website "https://www.saucedemo.com/"
    When User leaves username field blank "" and leaves password field blank ""
    And User clicks on Login button
    Then User can`t login and error message "Epic sadface: Username is required" is displayed











