Feature: Testing Luma add to cart feature

  @LumaAddToCartBag
  Scenario: Adding an item to cart
    Given user is on homepage
    When clicks gear dropdown menu then Bags
    And scrolls to Savvy shoulder tote and adds it to cart
    And checks cart
    Then the item should be in the cart