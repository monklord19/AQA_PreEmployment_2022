Feature: Homework week2 marti

  Background:
    Given You are on the login page

  Scenario: Successful logIn
    Given Entering valid credentials
    When  I click the login button
    Then  The product page is displayed