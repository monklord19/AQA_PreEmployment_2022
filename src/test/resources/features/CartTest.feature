Feature: Cart Tests


  Background:
    Given You are on the login page1

@Selenium
  Scenario: Add product to cart
    Given Login on the page
    When Add Sauce Labs Backpack in Cart
    And Go to cart
    Then Make sure item is in cart

    Scenario: Complete an order
      Given Login on the page
      And Add Sauce Labs Backpack in Cart
      And Go to cart
      When Click checkout button
      And Complete checkout first name with "primul nume" last name with "urmatorul nume" and the zip code with "numar posal"
      And Click continue button
      And Make sure  the Shipping Information is "FREE PONY EXPRESS DELIVERY!"
      And Click finish button
      Then Make sure  the "Your order has been dispatched, and will arrive just as fast as the pony can get there!" TEXT IS DISPLAYED

