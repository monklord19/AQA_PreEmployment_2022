Feature: BookStore API

  #POST user / generate token / authorized / delete
  Scenario: Create, login and delete user via API
    Given DemoQA login page
    When User is created and logged in via API
    Then User has token and authorized
    And User is deleted via API

  #GET user
  Scenario: Get user via API
    Given DemoQA login page
    When User is created, logged in and authorized via API
    Then Get user details via API

  #GET - /BookStore/v1/Books
  Scenario: Get all books from list
    Given On API address
    When Retrieve all books
    Then Response body should contain a JSON array of all books

  #POST and DELETE /Bookstore/v1/Books
  Scenario: Authorized user is able to add a book
    Given An authorized user
    When A list of books are available
    Then Add a book to reading list
    And Delete book from reading list by query param using userID

  #GET - /BookStore/v1/Book
  Scenario: Get one book by ISBN
    Given On API address
    When Retrieve a book by ISBN from the list
    Then Book should retrieve

  #DELETE - /BookStore/v1/Book
  Scenario: Delete book
    Given An authorized user
    When A list of books are available
    Then Add a book to reading list
    And Delete a book from reading list by ISBN and userID

  #PUT - /BookStore/v1/Books
  Scenario: Update reading list
    Given An authorized user
    When A list of books are available
    Then Add a book to reading list
    And Replace book from reading list