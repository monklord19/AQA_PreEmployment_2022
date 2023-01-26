Feature: MagentoAddToCart

  Background:
    Given I open magento website

  @LoginWithEmailOrUsername
  Scenario: Verify if product was added to cart
    When I hover on Gear and i press on the bags button
    Then  I add to cart Savvy Shoulder Tote
    And The bag should be in my cart