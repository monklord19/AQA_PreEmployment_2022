Feature: Reqres requests

  Background:
    Given The request specifications

  Scenario: GET API test-get users list
    When I send a valid request to fetch users
    Then I receive a list of users

  Scenario: POST API test-create user
    When I send a valid request with payload to create user
    Then The new user must be created

  Scenario: DELETE API test-delete user
    When I send a valid request for deleting a user
    Then The user must be deleted

  Scenario: PUT API test-update user
    When I send a valid request with payload for updating a user
    Then The user is updated

  Scenario:PATCH API test-partially update user
    When I send a valid request with payload for partially update a user
    Then The user is partially updated


