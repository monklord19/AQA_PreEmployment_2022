Feature: Testing login page

  Scenario Outline: Verify valid login
    Given I open login page
    When I enter <username> and <password>
    And Click login button
    Then Login successful, home page displayed
    Examples:
    | username | password |
    | standard_user|   secret_sauce  |
    | problem_user|  secret_sauce |
    | performance_glitch_user| secret_sauce |

  Scenario Outline: Verify invalid login
    Given I open login page
    When I enter <username> and <password>
    And Click login button
    Then Error message displayed
    Examples:
      | username | password |
      | standard|sauce  |
      |         |       |
      |          |  secret_sauce |
      | performance_glitch_user|  |

  Scenario: Verify if the ‘Enter’ key of the keyboard is working
    Given  I open login page
    When  I enter standard_user and secret_sauce
    And   Press enter key on keyboard
    Then   Login successful, home page displayed

