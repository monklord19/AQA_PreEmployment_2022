Feature: Doing a flow of steps on magneto website

  @Flow
  Scenario: Required flow on magneto website
    Given User opens magneto website
    And User hoover over Gears drop down list
    And User selects Bags
    When User scrolls down to Savvy Shoulder Tote
    And User click Add to Cart
    Then User should see his product in cart
