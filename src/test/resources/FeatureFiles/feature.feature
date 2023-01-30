Feature: BOOKSTORE API TESTING

  Background:
    Given I am an authorized user
    And I set request specifications

  Scenario: GET a book from bookstore
    Given A list of books is available
    When I send a valid request for fetching a book
    Then I receive the book

  Scenario: DELETE a book from bookstore
    Given A list of books is available
    When I send a valid request fot deleting a book
    Then The book is successfully deleted