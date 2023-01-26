Feature: ADD TO CART

  Scenario:
    Given User is on magento site
    And User Hover over Gear dropdown
    And User Select Bags
    When User scroll down and click add to cart button for Savy Shoulder Tote
    And User click on cart icon
    Then The product is added into cart