Feature: BookStore HTTPS reqs

  @AuthorizeUser
  Scenario: Authorize user
    Given User is on homepage
    When User inputs valid credentials and generates token
    Then User should be authorized

  @GETbooks
  Scenario: Get all books
    Given User is on homepage
    When Gets all the books
    Then All the books should be displayed

  @POSTbooks
  Scenario: Add a book
    Given User is on homepage
    When User adds a book
    Then The book should be added

  @DELETEbooks
  Scenario: Delete books
    Given User is on homepage
    When User deletes books
    Then The books should be deleted

  @GETbook
  Scenario: Get a book
    Given User is on homepage
    When User gets a specific book
    Then Book information should be displayed

  @DELETEbook
  Scenario: Delete a book
    Given User is on homepage
    When User removes a book
    Then The book should be removed

  @PUTbook
  Scenario: Update a book
    Given User is on homepage
    When User updates a book
    Then The book should be updated
