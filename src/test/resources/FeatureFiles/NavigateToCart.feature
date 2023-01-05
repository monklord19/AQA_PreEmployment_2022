Feature: Navigate
  This feature deals with user navigation through certain items

  @NavigateToCart
  Scenario:User navigates to Cart menu
    Given User logged in "https://www.saucedemo.com/"
    When User click on Shopping Cart
    Then User should see his cart