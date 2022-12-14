Feature: homework week 2

  Background:
    Given open the login page

  Scenario: Valid login into the page
    When I type the <Username> "standard_user" and <Password> as "secret_sauce"
    Then I should be logged in

  Scenario: The username does not belong in the list of valid usernames
    When I try to log in by using <Username> as "_user" and <Password> as "secret_sauce"
    Then I should not be logged in
    And  A pop-up saying "Username and password do not match any user in this service" should appear

  Scenario: The password does not correspond to the username
    When I try to log in by using <Username> as "locked_out_user" and <Password> as "_password"
    Then I should not be logged in
    And  A pop-up saying "Username and password do not match any user in this service" should appear

  Scenario: Both,the username and the password are not valid inputs
    When I try to log in by using <Username> as "_user" and <Password> as "_password"
    Then I should not be logged in
    And  A pop-up saying "Username and password do not match any user in this service" should appear

  Scenario: The inputs for username and password are empty
    When I try to log in by using <Username> as "" and <Password> as ""
    Then I should not be logged in
    And  A pop-up saying "Username is required" should appear

  Scenario: There is no value in the username field
    When I try to log in by using <Username> as "" and <Password> as "secret_sauce"
    Then I should not be logged in
    And  A pop-up saying "Username is required" should appear

  Scenario: There is no value in the password field
    When I try to log in by using <Username> as "problem_user" and <Password> as ""
    Then I should not be logged in
    And  A pop-up saying "Password is required" should appear

  Scenario: There is a value in the username field and the page is refreshed
    When I fill in <username> as "_user" and <Password> as  ""
    And  I press the refresh button of the webpage
    Then The username and password fields should be empty

  Scenario: There are values in the username field and in the password field and the page is refreshed
    When I fill in <username> as "_user" and <Password> as  "secret_sauce"
    And  I press the refresh button of the webpage
    Then The username and password fields should be empty
