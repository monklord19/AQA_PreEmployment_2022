Feature: TestApi

  Background: I am on demoqa page

  Scenario: Create User
    When I enter my credentials to create account
    Then I have an account

  Scenario: Generate Token
    When I enter my credentials to get token
    Then I receive a token

  Scenario: Authorization
    When I enter my credentials to get authorization
    Then I am authorized

  Scenario: Get User
    When I enter my UserId
    Then I get the user

  Scenario: Get all books
    When I want to get all books
    Then I successfully get all books

  Scenario: Get book
    When I want to get a book
    Then I successfully get the book

  Scenario: Add book to user
    When I want to add books to user
    Then I successfully add books to user

  Scenario: Update book
    When I want to update books
    Then I successfully update books

  Scenario: Delete books from user
    When I want to delete books from user
    Then I successfully delete books from user

#  Scenario: Delete books from inventory
#    When I want to delete books from inventory
#    Then I successfully delete books from inventory

  Scenario: Delete User
    When I enter my UserId to Delete
    Then I delete the user
