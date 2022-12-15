Feature: Testing SWANGLABS login page
  Background:
    Given user open the login page
    And the Username text box is empty
    And the Password text box is empty

  Scenario: Check login is successfully with valid credintials
    Given user is on login page
    When user enters username and password
    And user clicks on login
    Then user is navigated to the home page

  Scenario: Standard user login into the page
    Given the following user:
      | name                   | password     |
      |standard_user           | secret_sauce |
    When user type "standard_user" in 'Username' text box
    And user type "secret_sauce" in 'Password' text box
    And user click on 'LOGIN' button
    Then user should be logged in

  Scenario: Locked user login into the page
    Given the following user:
      | name                   | password     |
      |locked_out_user         | secret_sauce |
    When user type "locked_out_user" in 'Username' text box
    And user type "secret_sauce" in 'Password' text box
    And user click on 'LOGIN' button
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Sorry, this user has been locked out." should appear

  Scenario: Valid login into the page with pop-up error
    Given the following user:
      | name                | password     |
      |problem_user         | secret_sauce |
    When user type "problem_user" in 'Username' text box
    And user type "secret_sauce" in 'Password' text box
    And user click on 'LOGIN' button
    Then username text box should show an error
    And password text box should show an error
    Then user should be logged in
    And a pop up that recommends you to change password immediately should appear

  Scenario: Valid login login into the page but glitching the page
    Given the following user:
      | name                   | password     |
      |performance_glitch_user | secret_sauce |
    When user type "performance_glitch_user" in 'Username' text box
    And user type "secret_sauce" in 'Password' text box
    And user click on 'LOGIN' button
    Then the login page its frozen for a few seconds
    And user should be logged in

  Scenario: Error when adding a white space(backspace key) after correct username
    When user type valid username
    And user add a white space after the username
    And user type valid password for the current user
    And user click on 'LOGIN' button
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear

  Scenario: Error when username and password are empty
    When user click on "LOGIN" button
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username is required" should appear

  Scenario: Error when username is filled and password is empty
    When user type anything in username text box
    And password text box is empty
    And user click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Password is required" should appear

  Scenario: Error when username is empty and password is filled
    When user type anything in password text box
    And username text box is empty
    And user click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username is required" should appear

  Scenario: Wrong password
    When user type a valid username
    And user type a different password that the correct one
    And user click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear

  Scenario: Wrong username
    When user type a different username that the correct one
    And user type a valid password
    And user click on 'LOGIN'
    Then username text box should show an error
    And password text box should show an error
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear