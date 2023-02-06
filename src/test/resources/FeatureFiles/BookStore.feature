Feature: BOOKSTORE API TESTING

  Background: Setting request specifications
    Given I set request specifications
  @Account
  Scenario:Get a user
    And I am an authorized user
    When I send a valid request for fetching a user
    Then User is successfully fetched

  @Account
  Scenario: Delete a user
    When I send a valid request for deleting a user
    Then The user is deleted

  @BookStore
  Scenario:GET all books from bookstore
    When I send a valid request for fetching all books
    Then I receive a list of books

  @BookStore
  Scenario: GET a book from bookstore
    When I send a valid request for fetching a book
    Then I receive the book

  @Bookstore
  Scenario: ADD a book to reading list
    And I am an authorized user
    When I send a valid request for adding a book to reading list
    Then The book is successfully added

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

  @BookStore
  Scenario: Update a book
    And I am an authorized user
    When I send a valid request for updating a book
    Then The book is successfully updated




