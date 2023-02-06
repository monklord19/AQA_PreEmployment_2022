Feature: Testing account

  Scenario: Create a user (POST method)
    Given I am on the reqres website
    When I a user with a specific username and password
    Then The user is added

