Feature: Testing login page

  Scenario Outline: Verify login
    Given I open login page
    When I enter <user> and <pass>
    And Click login button
    Then Login successful, home page displayed
    Examples:
    | user | pass |
    | standard_user|   secret_sauce  |
    | problem_user|  secret_sauce |
    | performance_glitch_user| secret_sauce |

  Scenario Outline: Verify invalid login
    Given I open login page
    When I enter <user> and <pass>
    And Click login button
    Then Error message displayed
    Examples:
      | user | pass |
      | standard|sauce  |
      |         |       |
      |          |  secret_sauce |
      | performance_glitch_user|  |

  Scenario: Verify if the ‘Enter’ key of the keyboard is working
    Given  I open login page
    When  I enter standard_user and secret_sauce
    And   Press enter key on keyboard
    Then   Login successful, home page displayed

