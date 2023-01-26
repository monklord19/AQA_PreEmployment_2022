Feature:Cart test

  Background:
    Given I open the website magento

  @VerifyAddToCartButtons
  Scenario: Verify add to cart button from every product
    When I enter the "standard_user" and "secret_sauce"
    Then I should be logged successfully
    And  I should see the add to cart button from every picture
    Then i should click on every button and each one shoould change their text from add to cart to remove

  @VerifyTheRemoveButton
  Scenario: After I logged successfully I verify if i can add and remove an item from cart
    When I enter the "standard_user" and "secret_sauce"
    And I'm successfully login
    And I add an item to card pressing the button add to cart
    Then The item should be added successfully
    And I should see the item in my cart and successfully remove it