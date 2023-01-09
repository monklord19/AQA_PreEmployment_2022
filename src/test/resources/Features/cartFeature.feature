Feature: Cart feature

Scenario: Add product to cart
Given User is logged in on website "https://www.saucedemo.com/" with username "standard_user" and password "secret_sauce"
When User clicks on add to cart on product Sauce Labs Backpack
Then Product is added to cart
