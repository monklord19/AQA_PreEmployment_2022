Feature: Book Store API tests

  Background:
    Given set base URI and PATH book store

  Scenario: POST request for new user registration status codes
    When send POST request for registration of new user with username: 'SRadu1056' and password: 'Tast@tura1234'
    Then status code is: 201
    When send POST request to generate token a for user with username: 'SRadu1056' and password: 'Tast@tura1234'
    Then status code is: 200

  Scenario: GET request list of books status code
    When send a GET request for list of books
    Then status code is: 200

  Scenario: GET request of books in list
    When send a GET request for list of books
    Then number of books is: 8

  Scenario: GET book status code
    When send a GET request for book no.2
    Then status code is: 200

  Scenario: POST request add book on user list
    When send a POST request for adding book no.2 on users list
    Then status code is: 201

  Scenario: POST request add book on user list
    When send a POST request for adding book no.3 on users list
    Then status code is: 201

  Scenario: POST request add book on user list
    When send a POST request for adding book no.6 on users list
    Then status code is: 201

#  Scenario: DELETE request for a book
#    When send a POST request for adding a book on users list
#    And send a DELETE request for a book
#    Then status code is: 200



