Feature: BOOKSTORE API TESTING

  Background: Setting request specifications
    Given I set request specifications

  @Account
  Scenario: Delete a user
    When I send a valid request for deleting a user
    Then The user is deleted

  @BookStore
  Scenario: DELETE a book from reading list
    And I am an authorized user
    When I send a valid request for deleting a book
    Then The book is successfully deleted

  @BookStore
  Scenario: DELETE books from bookstore
    And I am an authorized user
    When I send a valid request for deleting multiple books
    Then The books are deleted