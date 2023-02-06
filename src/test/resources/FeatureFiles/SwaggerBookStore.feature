Feature: Testing BookStore

  Scenario: GET specific book
    Given On the Swagger BookStore API
    When I send a GET request for the Speaking JavaScript book
    Then I check the status code
    And The response body contains the isbn value and title

  Scenario: GET all books
    Given On the Swagger BookStore API
    When I send a GET request for all books
    Then I check status code
    And I check the number of books retrieved