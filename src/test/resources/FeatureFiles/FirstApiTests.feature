Feature:Testing a REST API

  Scenario: User wants to see list users
    Given user opens website "https://reqres.in/"
    When user wants to get list users
    Then the response should be success

  Scenario: User wants to see single user
    Given user opens website "https://reqres.in/"
    When user wants to get single list
    Then the response should be success

  Scenario: User wants to create a user
    Given user opens website "https://reqres.in/"
    When user wants to create a user
    Then the response should be created

  Scenario: User wants to get single user not found
    Given user opens website "https://reqres.in/"
    When user wants to get single user not found
    Then the response should be not found

  Scenario: User wants to see resource list
    Given user opens website "https://reqres.in/"
    When user wants to get resource list
    Then the response should be success

  Scenario: User wants to see  single resource
    Given user opens website "https://reqres.in/"
    When user wants to get single resource
    Then the response should be success

  Scenario: User wants to get single resource not found
    Given user opens website "https://reqres.in/"
    When user wants to get single resource not found
    Then the response should be not found

  Scenario: User wants to update a user
    Given user opens website "https://reqres.in/"
    When user wants to update a user
    Then the response should be success

  Scenario: User wants to delete a user
    Given user opens website "https://reqres.in/"
    When user wants to delete a user
    Then the response should be no content

  Scenario: User wants to get delayed response
    Given user opens website "https://reqres.in/"
    When user wants to get delayed response
    Then the response should be success and greater than 3000L