Feature: testLogin - homeWork

  Background:
    Given You are at login page on https://www.saucedemo.com

  Scenario: Login with valid credentials on https://www.saucedemo.com
    Given I am on the login page
    When I fill in <userName> with <problem_user>
    And  I fill in <password> with <secret_sauce>
    And  I press <Login>
    Then I should be on the user home page

  Scenario: Login with invalid userName and valid password
    Given user insert invalid userName <text_text>
    When user insert valid password <secret_sauce>
    Then user click on <LOGIN>
    And error message displays <Epic sadface: Username and password do not match any user in this service>

  Scenario: Fill with valid userName and valid password and press <spacebar> 1 time at the end
   Given user type <problem_user> with <spacebar> pressed at the end
   When  user type <secret_sauce> with <spacebar> pressed at the end
   Then click on <Login>
   And warning message is displayed <Epic sadface: Username and password do not match any user in this service>

  Scenario: Login with without credentials
    Given user open the login page
    When user fill the "userName" with <blank>
    And user fill the <password> with <blank>
    Then press <Login>
    And warning message is displayed <Epic sadface:Username is required>

  Scenario: Open 3 new windows and navigate to https://www.saucedemo.com in each window login with valid credentials
    Given user open 3 windows and navigate to https://www.saucedemo.com
    When user fills valid <userName> for each window
    And user fills  valid <password> for each window
    Then user is logged in succesfully

  Scenario: User log out of each page
    Given user navigate to <Sign out> option
    When user click on <Sign out>
    Then user should be succesfully signed out

  Scenario:Fill the username and password box with valid credentials followed by the <Enter> key
   Given user write valid <userName>
   And press <Enter> key
   When user write valid <password>
   And press <Enter> key
   Then user should not be loged in
   And error appears <Epic sadface: Username and password do not match any user in this service>