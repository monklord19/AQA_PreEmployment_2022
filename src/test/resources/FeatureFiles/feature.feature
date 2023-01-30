Feature: Test Luma website
  @Luma
  Scenario: Testing Add Bag on Luma website
    Given I open website
    And I hoover over Gears drop down
    And I select Bags
    When I select  Savvy Shoulder Tote
    And I click Add to Cart
    Then I should see Bag in cart