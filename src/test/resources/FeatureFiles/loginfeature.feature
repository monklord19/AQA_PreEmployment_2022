Feature: Test Login Page

  Background:
    Given User open test website


  Scenario: Login with valid credentials
    Given Entering valid credentials
    When I click the login button
    Then User is on ProductPage


  Scenario: Add backpack to the cart
    Given Navigate to product page
    And Backpack added to cart
    When Navigate to the cart
    Then The product should be there