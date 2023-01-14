Feature: test case for luma website
  Background:
    Given on luma website

  Scenario:I verify if the object added to the cart is correct
    When I hover over gear field and press the bags option
    And I scroll and hover over the item "Savvy Shoulder Tote" and click on add to cart
    Then Product should be added to cart with the name "Savvy Shoulder Tote"