Feature: Sign-in
  Scenario Outline: I try to sign-in with valid username and correct password
    Given I open https://www.saucedemo.com/
    When I enter <username> and <password>
    Then I am successfully logged in
    Examples: | username                | password     |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |

  Scenario: I try to sign-in with valid username and correct password
    Given I open https://www.saucedemo.com/
    When I enter username: locked_out_user and password: secret_sauce
    Then Failed sign-in with error msg: "Epic sadface: Sorry, this user has been locked out."

  Scenario Outline: I try to sign-in with valid username and no password
    Given I open https://www.saucedemo.com/
    When I enter <username> and <password>
    Then Failed sign-in with error: "Epic sadface: Password is required"
    Examples: | username                | password     |
    | standard_user           |  |
    | locked_out_user         |  |
    | problem_user            |  |
    | performance_glitch_user |  |

  Scenario Outline: I try to sign-in with valid username and wrong password
    Given I open https://www.saucedemo.com/
    When I enter <username> and <password>
    Then Failed sign-in with error: "Epic sadface: Username and password do not match any user in this service"
    Examples: | username                | password     |
    | standard_user           | password1234 |
    | locked_out_user         | password1234 |
    | problem_user            | password1234 |
    | performance_glitch_user | password1234 |

  Scenario Outline: I try to sign-in with no username and correct password
    Given I open https://www.saucedemo.com/
    When I enter <username> and <password>
    Then Failed sign-in with error: "Epic sadface: Username is required"
    Examples: | username | password     |
    |          | secret_sauce |
    |          | secret_sauce |
    |          | secret_sauce |
    |          | secret_sauce |