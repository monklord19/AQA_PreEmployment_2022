Feature: add to cart

  Scenario: As a user I can add an item to the cart
    Given On sauce website
    Given I enter the username "problem_user"
    And I enter the password "secret_sauce"
    When I press the login button
    Then  I should be logged in
    When I press ADD TO CART button on the first product
    Then The cart is not empty