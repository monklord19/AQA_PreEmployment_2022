@apiTests
Feature: Api tests


  @tokenScenario
  Scenario: Generate the token
    When Generate token
    Then Status code 200

  Scenario: Authorize the user
    Given The endpoint is provided
    When User is authorized
    Then The body is printed and status code checked

  Scenario: Create user and  delete user test
    Given Provide the endpoint
    When Create the user
    Then Print body and check status code
    And Create new token for the user
    When Delete created user
    Then Check if user is deleted

  Scenario: Get user by id
    Given Endpoint is provided and call is made
    When  Print Body
    Then Check the status code

  Scenario: Get all book
    Given Provide endpoint
    When Print all the books
    Then Check status code

  Scenario: Get first book
    Given Endpoint provided and call is made
    When Print the body
    Then Check the status code

  Scenario: Add book request and delete
    Given Endpoint provided
    When Post request is sent  and book is added
    Then Status code is checked and body is printed
    When Delete added book from collection
    Then Check deleted book


  Scenario: Put request
    Given The put request is made and book is changed
    When Print Body
    Then Check status code

  Scenario: Delete all books
    When Delete all books call
    Then Check all books are deleted

  Scenario Outline:
    Given Endpoint provided
    When Post request is sent  and "<booksId>" is added
    Then Check books are added
    Examples:
      | booksId       |
      | 9781449331818 |
      | 9781449337711 |
      | 9781449365035 |