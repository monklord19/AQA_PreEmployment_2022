
Feature: API Tests on Demo QA - Bookstore

  Background: User is an authorized user

  Scenario: Create an new user - POST/Account/User
    Given User is on demoQA website
    When User creates a new user
    Then Registration is successful
    And Status Response is 200


  Scenario:  Generate Token - POST/Account/Generate Token
    Given User is an authorized user
    And User is on demoQA website
    When Authorized user generates token
    Then Token is generated successfully
    And Status Response equals 200


  Scenario: Authorize User - POST/Account/Authorized     //correct tot scenariul
    Given User is an authorized user
    And User is on demoQA website
    When User makes a POST method for authorization
    Then Status Response will be 200
    And Response header will be displayed


  Scenario: Delete User - DELETE/Account/User
    Given User is an authorized user
    And User is on demoQA website
    When User deletes a user
    Then User is successfully deleted with status 200
    And Response header will appear


  Scenario: Get User - GET/Account/User
    Given User is an authorized user
    And User is on demoQA website
    When User executes a GET request
    Then Status response will be successful


  Scenario: Get the list of available books - GET/BookStore/Books  //correct tot scenariul
    Given User is an authorized user
    And User is on demoQA website
    When User executes a GET request to get the list of available books
    Then The list with all the available book will be displayed
    And Status will be 200


  Scenario: Add list of books - POST/BookStore/Books // imi da Time out
    Given User is an authorized user
    And User is on demoQA website
    When User executes a POST request to add a new list
    Then The new list will be added
    And Response will be 200


  Scenario: Delete a book - DELETE/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a DELETE request to delete a book
    Then The book is successfully deleted


  Scenario: Get details about a particular book - GET/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a GET request to get details about a particular book
    Then The details are displayed


  Scenario: Replace a book - PUT/BookStore/Books
    Given User is an authorized user
    And User is on demoQA website
    When User executes a PUT request to replace a particular book
    Then The book is successfully replaced






