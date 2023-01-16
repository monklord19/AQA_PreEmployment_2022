Feature: Adding products to shopping cart

  Scenario: Add products to shopping cart
    Given I am logged in on the Luma website
    When I hover over the Gear menu item and select Bags
    And I scroll down to Savvy Shoulder Tote and click Add to Cart
    Then The 'Savvy Shoulder Tote' product is added to the cart and 'You added Savvy Shoulder Tote to your shopping cart.' message is displayed.