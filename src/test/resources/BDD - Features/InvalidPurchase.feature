@InvalidPurchase
Feature: Invalid Purchase Feature
  as user i want to input invalid checkout information
  Scenario Outline:
    Given user open the web page
    When user input "standard_user" as userName and "secret_sauce" as password
    And user already choose "'Sauce Labs Backpack'" as one item
    When user sort product list by "Name (Z to A)"
    And user pick 2 item in the top list
    Then user go to detail cart page and remove last item
    When user input "<firstName>" as firstName and "<lastName>" as lastName and "<postalCode>" as postalCode
    Then user will get "<errorText>" on checkout page
    Examples:
      | firstName | lastName | postalCode | errorText                      |
      |           |          |            | Error: First Name is required  |
      |           | asd      | 123        | Error: First Name is required  |
      | asd       |          | 123        | Error: Last Name is required   |
      | asd       | asd      |            | Error: Postal Code is required |
      | asd       |          |            | Error: Last Name is required   |
      |           | asd      |            | Error: First Name is required  |
      |           |          | 123        | Error: First Name is required  |