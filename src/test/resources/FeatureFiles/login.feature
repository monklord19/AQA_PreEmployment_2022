@Smoke
Feature: Log-in

  @ValidLogin
  Scenario Outline: Sign-in with valid username and correct password
    Given User is on URL
    When User enters <username> and <password>
    And User clicks on login button
    Then User is successfully logged in
    Examples:
    | username                | password     |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |

  @LockedOutUser
  Scenario: Sign-in with valid username and correct password
    Given User is on URL
    When User enters credentials
    And User clicks on login button
    Then Failed sign-in with error msg

  @NoPassword
  Scenario Outline: Sign-in with valid username and no password
    Given User is on URL
    When User enters <username> and <password>
    And User clicks on login button
    Then Failed sign-in. Password required
    Examples:
    | username                | password |
    | standard_user           |          |
    | locked_out_user         |          |
    | problem_user            |          |
    | performance_glitch_user |          |

  @WrongPassword
  Scenario Outline: Sign-in with valid username and wrong password
    Given User is on URL
    When User enters <username> and <password>
    And User clicks on login button
    Then Failed sign-in with error. Wrong password
    Examples:
    | username                | password     |
    | standard_user           | password1234 |
    | locked_out_user         | password1234 |
    | problem_user            | password1234 |
    | performance_glitch_user | password1234 |

  @NoUsername
  Scenario Outline: Sign-in with no username and correct password
    Given User is on URL
    When User enters <username> and <password>
    And User clicks on login button
    Then Failed sign-in with error. Username is required
    Examples:
    | username | password     |
    |          | secret_sauce |
    |          | secret_sauce |
    |          | secret_sauce |
    |          | secret_sauce |

  @addToCart
