Feature: Proiect Final - API
  Background:
    Given user enters on DemoQA Swagger

  Scenario: Create new user
    When user sends valid post request to create new user
    Then new user is created

 Scenario: User checks if is authorized
    When user sends valid post request to check is authorized
    Then user is authorized

  Scenario: User generates token
    When user sends valid post request to generate token
    Then token is generated

  Scenario: User logs in
    When user sends valid post request to get user info
    Then userId is generated

  Scenario: View user details
    When user sends valid post request to get user details
    Then user details are retrieved

  Scenario:View books details
    When user sends valid get request to get books details
    Then books details are retrieved

  Scenario:Add new book in list books
    When user sends valid post request to add books into collection
    Then books are added into  user's collection

  Scenario:Update list books with isbn
    When user sends valid post request to update book in the list
    Then book list is updated

  Scenario:Delete books from the list
    When user sends delete request to delete books from the collection
    Then books are deleted from the user's collection

  Scenario:View book details
    When user sends valid get request to get book details
    Then book details are retrieved

Scenario: Delete user by UserId
  When user sends valid post request to delete user
  Then user is deleted if exists




