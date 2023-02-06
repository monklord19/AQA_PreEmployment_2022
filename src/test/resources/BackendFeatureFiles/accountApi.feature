@api
Feature: Account/v1 endpoint

  Background:
    Given set BASE URI

  Scenario: POST /Account/v1/User
    When send a POST request for registration of new user with username: "testUser56" and password: "!@#A12SDa"
    Then response body contains path: "username", value: "testUser56"

  Scenario: POST /Account/v1/GenerateToken
    When send POST request to generate token for user with username: "testUser56" and password: "!@#A12SDa"
    Then response body contains path: "status", value: "Success"
    And response body contains path: "result", value: "User authorized successfully."

  Scenario: POST /Account/v1/Authorized
    When send a POST request for confirmation of authorization with username: "testUser56" and password: "!@#A12SDa"
    Then response contains: "true"

  Scenario: GET /Account/v1/User/{UUID}
    When send a GET request for account details for userID
    Then response body contains path: "username", value: "testUser56"

  Scenario: DELETE /Account/v1/User/{UUID}
    When send a DELETE request for userID
    And send a GET request for account details for userID
    Then status code is 401
    And response body contains path: "message", value: "User not found!"
