Feature: Cart

  Scenario: Products are added to Cart
    Given user is logged in
    When user clicks on Add to cart button having Product as "Sauce Labs Backpack"
    And user clicks on Cart icon
    Then product "Sauce Labs Backpack" with Price 29.99 and Quantity 1 is added to the Cart