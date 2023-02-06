@api
Feature: BookStore/v1 endpoint
  Background:
    Given set BASE URI

  Scenario: POST /Account/v1/User and POST /Account/v1/GenerateToken
    When send a POST request for registration of new user with username: 'SRadu1070' and password: 'Tast@tura1234'
    Then send POST request to generate token for user with username: 'SRadu1070' and password: 'Tast@tura1234'

  Scenario: GET /BookStore/v1/Books
    When send a GET request for list of books
    Then number of books is: 8

  Scenario: GET /BookStore/v1/Book
    When send a GET request for book no.3
    Then response body contains path: "isbn", value: "9781449337711"
    And response body contains path: "title", value: "Designing Evolvable Web APIs with ASP.NET"

  Scenario: POST /BookStore/v1/Books
    When send a POST request for adding book no.3 on users list
    And send a POST request for adding book no.1 on users list
    And send a POST request for adding book no.4 on users list
    And send a GET request for account details for userID
    Then response body contains path: "books[0].title", value: "Designing Evolvable Web APIs with ASP.NET"
    And response body contains path: "books[1].title", value: "Git Pocket Guide"
    And response body contains path: "books[2].title", value: "Speaking JavaScript"

  Scenario: DELETE /BookStore/v1/Book
    When send a DELETE request for book no.1 from user list
    And send a GET request for account details for userID
    Then number of books is: 2
    And "Designing Evolvable Web APIs with ASP.NET" not present in user's book list

  Scenario: PUT /BookStore/v1/Books/{ISBN}
    When send a PUT request for replacing book no.1 from user books list with book no.6 from book store books list
    Then "Git Pocket Guide" not present in user's book list
    And "Programming JavaScript Applications" is present in user's book list

  Scenario: DELETE /BookStore/v1/Books
    When send a DELETE request for all books from user list
    And send a GET request for account details for userID
    Then number of books is: 0

  Scenario: DELETE /Account/v1/User/{UUID}
    When send a DELETE request for userID
    And send a GET request for account details for userID
    Then status code is 401
    And response body contains path: "message", value: "User not found!"




