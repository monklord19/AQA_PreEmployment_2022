@Smoke
Feature: Testing SWANGLABS login page

  @ValidLogin
  Scenario Outline: Login successful with valid credentials
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "<username>" and password as "<password>"
    And user clicks on login
    Then Home page opens

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @InvalidLogin
  Scenario: Login with invalid credentials
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard_user9" and password as "secret_sauceeee"
    And user clicks on login button
    Then error message is displayed "Epic sadface: Username and password do not match any user in this

  @InvalidLogin
  Scenario: Login with blank credintials
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "" and password as ""
    And user clicks on login button
    And a red pop-up text box containing "Epic sadface: Username is required" should appear

  @InvalidLogin
  Scenario: Login with valid username and password empty
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard_user" and password as ""
    And user clicks on login button
    Then a red pop-up text box containing "Epic sadface: Password is required" should appear

  @InvalidLogin
  Scenario: Login with username empty and valid password
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "" and password as "secret_sauce"
    And user clicks on login button
    And a red pop-up text box containing "Epic sadface: Username is required" should appear

  @InvalidLogin
  Scenario: Wrong password
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard_user" and password as "secret"
    And user clicks on login
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear

  @InvalidLogin
  Scenario: Wrong username
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard" and password as "secret_sauce"
    And user clicks on login
    And a red pop-up text box containing "Epic sadface: Username and password do not match any user in this service" should appear

  @ValidLogin
  Scenario: Login by pressing Enter key
    Given user navigates to "https://www.saucedemo.com/"
    When user enters username as "standard_user" and password as "secret_sauce"
    And user presses Enter key
    Then Home page opens

  Scenario: User successfully logged out
    Given user is logged in
    When user clicks on hamburger button
    And user clicks on logout button
    Then Login page should reopens

  Scenario: User add product to cart
    Given user is logged in
    When user click on add to cart button
    Then cart page opens
    And product should appear in cart

