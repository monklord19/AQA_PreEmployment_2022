Feature: Cart feature
  Background:
    Given User opens login page
  Scenario: Add an item to the cart
    And User is logged
    When User click on Add to cart button for the product "Sauce Labs Bolt T-Shirt"
    And User click on Cart pictogram
    Then The product "Sauce Labs Bolt T-Shirt" is successfully added to the cart

  Scenario: Product is removed from the cart
    And User is logged
    And User click on Add to cart button for the product "Sauce Labs Bolt T-Shirt"
    And User click on Cart pictogram
    And User click on Remove button
    Then The product is removed from the cart