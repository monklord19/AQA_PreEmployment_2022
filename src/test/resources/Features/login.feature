Feature: Testing SWANGLABS login page
  Background:
    Given I open the login page
    And the Username text box is empty
    And the Password text box is empty

  Scenario: Valid login into the page
    Given I have user:
      | name                   | password     |
      |standard_user           | secret_sauce |
    When I type <standard_user> in 'Username' text box
    And I type <secret_sauce> in 'Password' text box
    And I click on 'LOGIN' button
    Then I should be logged in

  Scenario: Locked user login into the page
    Given I have user:
      | name                   | password     |
      |locked_out_user         | secret_sauce |
    When I type <locked_out_user> in 'Username' text box
    And I type <secret_sauce> in 'Password' text box
    And I click on 'LOGIN' button
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Sorry, this user has been locked out." should appear

  Scenario: Valid login into the page with pop-up error
    Given I have user:
      | name                | password     |
      |problem_user         | secret_sauce |
    When I type <problem_user > in 'Username' text box
    And I type <secret_sauce> in 'Password' text box
    And I click on 'LOGIN' button
    Then username text box should show an error
    And password text box should show an error
    Then I should be logged in
    And a pop up that recommends you to change password immediately should appear

  Scenario: Valid login login into the page but glitching the page
    Given I have user:
      | name                   | password     |
      |performance_glitch_user | secret_sauce |
    When I type <performance_glitch_user> in 'Username' text box
    And I type <secret_sauce> in 'Password' text box
    And I click on 'LOGIN' button
    Then the login page its frozen for a few seconds
    And I should be logged in

  Scenario: Error when adding a white space(backspace key) after correct username
    When I type valid username
    And I add a white space after the username
    And I type valid password for the current user
    And I click on 'LOGIN' button
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear

  Scenario: Error when username and password are empty
    When I click on "LOGIN" button
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username is required" should appear

  Scenario: Error when username is filled and password is empty
    When I type anything in username text box
    And password text box is empty
    And I click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Password is required" should appear

  Scenario: Error when username is empty and password is filled
    When I type anything in password text box
    And username text box is empty
    And I click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username is required" should appear

  Scenario: Wrong password
    When I type a valid username
    And I type a different password that the correct one
    And I click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear

  Scenario: Wrong username
    When I type a different username that the correct one
    And I type a valid password
    And I click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear
