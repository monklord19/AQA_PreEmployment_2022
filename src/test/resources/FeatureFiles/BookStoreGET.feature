Feature: BOOKSTORE API TESTING

  Background:
    Given I create a user
    And I am an authorized user
    And I generate a token

  Scenario:GET all books from bookstore
    When I send a valid request for fetching all books
    Then I receive a list of books

  Scenario: GET a book from bookstore
    When I send a valid request for fetching a book
    Then I receive the book

