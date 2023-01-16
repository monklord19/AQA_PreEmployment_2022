Feature: Add product to bag

  Scenario: Add a product to cart
    Given On site
    When User selects gear and then selects bags
    And User adds product to cart
    Then Product is in cart