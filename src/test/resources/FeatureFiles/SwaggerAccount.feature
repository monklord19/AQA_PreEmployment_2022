Feature: Testing account

  Scenario: Create a user (POST method)
    Given I am on the BookStore website
    When I a user with a specific username and password
    Then The user is added

  Scenario: Authorize, generate token for a user (POST method)
    Given I am on the BookStore website
    When I authorize and generate token a user with a specific username and password
    Then The user is authorized
