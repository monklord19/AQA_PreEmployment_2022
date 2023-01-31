Feature: BOOKSTORE API TESTING

  Background:
    Given I create a user
    And I am an authorized user
    And I generate a token

  Scenario: ADD a book to bookstore
    When I send a valid request for adding a book
    Then The book is successfully added

  Scenario: DELETE a book from bookstore
    When I send a valid request fot deleting a book
    Then The book is successfully deleted