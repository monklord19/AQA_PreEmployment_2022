Feature: BOOKSTORE API TESTING

  Background: Setting request specifications
    Given I set request specifications

  @Account
  Scenario:Create a user account
    When I send a valid request for creating a new user
    Then User is created
  @Account
  Scenario: Authorize the user
    When I send a valid request for authorizing the user
    Then The user is authorized

  @Account
  Scenario: Generate a token
    When I send a valid request for generating a token
    Then Token is successfully generated

  @Account
  Scenario:Get a user
    And I am an authorized user
    When I send a valid request for fetching a user
    Then User is successfully fetched

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
  Scenario: Update a book
    And I am an authorized user
    When I send a valid request for updating a book
    Then The book is successfully updated




