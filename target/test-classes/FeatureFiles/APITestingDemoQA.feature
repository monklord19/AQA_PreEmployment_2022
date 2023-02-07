
Feature: API Tests on Demo QA - Bookstore


  Scenario: Scenario No. 1 - Create a new user - POST/Account/User
    Given User is on demoQA website
    When User creates a new user using the POST method
    Then Status Response is 200


  Scenario: Scenario No. 2 - Generate Token - POST/Account/Generate Token
    Given User is on demoQA website
    When User generates token
    Then Token is generated successfully


  Scenario: Scenario No. 3 - Authorize User - POST/Account/Authorized
    Given User is an authorized user
    And User is on demoQA website
    When User makes a POST method for authorization
    Then Status Response will be 200
    And Response header will be displayed


  Scenario: Scenario No. 4 - Delete User - DELETE/Account/User
    Given User is an authorized user
    And User is on demoQA website
    When User deletes a user
    Then User is successfully deleted


  Scenario: Scenario No. 5 - Get Book - GET/Account/User
    Given User is an authorized user
    And User is on demoQA website
    When User executes a GET request
    Then Status response will be successful


  Scenario: Scenario No. 6 - Get the list of available books - GET/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a GET request to get the list of available books
    Then The list with all the available book will be displayed
    And Status will be 200
    And The call will have a response header


  Scenario: Scenario No. 7 - Add a book to my list - POST/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a POST request to add a new book
    Then The new book will be added and Response will be 200


  Scenario: Scenario No. 8 - Delete a book - DELETE/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a DELETE request to delete a book
    Then The book is successfully deleted


  Scenario: Scenario No. 9 - Get details about a particular book - GET/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a GET request to get details about a particular book
    Then The details are displayed


  Scenario: Scenario No. 10 - Update a book - PUT/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a PUT request to update a particular book
    Then The book is successfully updated






