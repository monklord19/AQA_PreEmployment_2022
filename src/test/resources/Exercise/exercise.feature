@Smoke
Feature: Exercise

  Scenario: Add a bag in the cart
    Given User open the webpage of Luma
    And User access the Gear category
    And User access the Bag subcategory
    And User add the pink bag to the cart
    Then User check the shopping cart

