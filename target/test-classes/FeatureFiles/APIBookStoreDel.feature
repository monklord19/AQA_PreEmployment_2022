
  Feature: API Tests
    Background: User generates token for Authorisation
      Given: I am an authorized user

      Scenario: Authorized user is able to ADD and Remove a book
        Given A list of books are available
        When I add a book to my reading list
        Then The book is added
        When I remove a book from my reading list
        Then The book is removed