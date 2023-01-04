@Purchase
Feature: Purchase Flow
  as a user want to purchase order 2 item

  Scenario:
    Given user open the web page
    When user input "standard_user" as userName and "secret_sauce" as password
    And user already choose "'Sauce Labs Backpack'" as one item
    When user sort product list by "Name (Z to A)"
    And user pick first "item" with Test.allTheThings T-Shirt
    And user pick second "item" with Sauce Labs Onesie
    Then user go to detail cart page and remove last item
    When user input "john" as firstName and "poltak" as lastName and "55851" as postalCode
    Then user will see "Item total: $37.98" as expected itemTotal and "Tax: $3.04" as expected tax
    And user will see "Total: $41.02" as expected total
    Then user go to finish page and will see "THANK YOU FOR YOUR ORDER" as completeHeader