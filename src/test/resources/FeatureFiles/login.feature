Feature: Logging in to https://www.saucedemo.com/

  @SuccessfulLogin
  Scenario: Log in with valid username and password
    Given I open saucedemo site
    When I enter valid username in the username field
    And I enter valid password in the password field
    And I click the Login button
    Then I should be logged in

  Scenario: Log in with a restrictive set of valid credentials
    Given I open saucedemo site
    When I enter valid username and password
    And I click the Login button
    Then I should be logged in
#    Examples:
#      | userName                | password     |
#      | standard_user           | secret_sauce |
#      | problem_user            | secret_sauce |
#      | performance_glitch_user | secret_sauce |

#  @BlankCredentials
#  Scenario: Log in with blank username and password
#    Given I open saucedemo site
#    When I click the Login button
#    Then I am unable to log in
#    And Error message is displayed "Epic sadface: Username is required"
#
#  @BlankUsername
#  Scenario: Log in with blank username and valid password
#    Given I open saucedemo site
#    When I enter a valid password
#    And I click the Login button
#    Then I am unable to log in
#    And Error message is displayed "Epic sadface: Username is required"
#
#  @BlankPassword
#  Scenario: Log in with valid username and blank password
#    Given I open saucedemo site
#    When I enter a valid username
#    And I click the Login button
#    Then I am unable to log in
#    And Error message is displayed "Epic sadface: Password is required"
#
#   @InvalidCredentials
#  Scenario: Log in with invalid username and password
#    Given I open saucedemo site
#    When I enter the "standard_use" username and "secret_sauce" password
#    And I click the Login button
#    Then I am unable to log in
#    And Error message is displayed "Epic sadface: Username and password do not match any user in this service"
#
#  @InvalidPassword
#  Scenario: Log in with valid username and invalid password
#    Given I open saucedemo site
#    When I enter a valid username and an invalid password
#    And I click the Login button
#    Then I am unable to log in
#    And Error message is displayed "Epic sadface: Username and password do not match any user in this service"
#
#  @AccessibleLogin
#  Scenario: Log in using 'Tab' key to navigate and 'Enter' to log in
#    Given I open saucedemo site
#    When I use Tab to move focus to username field
#    And I enter valid username
#    And I use Tab to move focus to password field
#    And I enter a valid password
#    And I use Enter
#    Then I am able to log in
#
#  @BackForwardButtons
#  Scenario: Log in w/o credentials by using the 'Back' and 'Forward' buttons
#    Given I open saucedemo site
#    When I return to the login page via the ‘Back' button of the browser
#    And I use the 'Forward' button
#    Then I am able to log in without adding my credentials
#
#  @Logout
#  Scenario: Log out of https://www.saucedemo.com/
#     Given I am logged in to https://www.saucedemo.com/
#     When I select LOGOUT from the hamburger menu list
#     Then I am able to log out

