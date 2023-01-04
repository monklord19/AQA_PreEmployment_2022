Feature: Tests for inventory
  Background:
    Given  User is logged in

    Scenario: After being logged in, I check if the item i added to cart is the same
      When  I add a backpack to cart
      And  I open the shopping cart
      Then Item in cart should be called "Sauce Labs Backpack"

    Scenario: After being logged in, I press the logout button and check if the username and password fields are empty
      When I click on the menu button
      And I press logout
      Then The username and password fields should be empty