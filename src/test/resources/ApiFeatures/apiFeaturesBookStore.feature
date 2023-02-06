Feature: Bookstore API testing

  Scenario: GET request to get all the books
    Given I am on DemoQA
    When I send a get request to get all the books
    Then I get all books

  Scenario: POST request to give book at an user
    Given I am on DemoQA
    When I send a post request to give book to an user by entering userID
    Then book will be assigned to user

  Scenario: GET request to get one specific book
    Given I am on DemoQA
    When I send a get request to get one specific book by entering ISBN
    Then I get the specific book

