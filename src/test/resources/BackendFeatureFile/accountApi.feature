Feature: Account API tests

  Background:
    Given set base URI and PATH account

  Scenario: POST request for new user registration status code
    When send a POST request for registration of new user with username: "testUser34" and password: "!@#A12SDa"
    Then status code is 201

  Scenario: POST request to generate token status code
    When send POST request to generate token for user with username: "testUser34" and password: "!@#A12SDa"
    Then status code is 200

  Scenario: POST request confirmation for authorization status code
    When send a POST request for confirmation of authorization with username: "testUser34" and password: "!@#A12SDa"
    Then status code is 200

  Scenario: GET request account details
    When send a GET request for account details for userID
    Then status code is 200

  Scenario: DELETE account
    When send a DELETE request for userID
    Then status code is 204