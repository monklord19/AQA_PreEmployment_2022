Feature:ApiScenario

  @CreateUser
  Scenario: Create an user
    When I send a POST request to "/User"
    Then The response status code for it should be 201

  @GetUserInfo
  Scenario: Show User Info
    When I send a GET request
    Then The response code should be 200
    And The response body should contain the user information

  @GenerateToken
  Scenario: Generate Token
    When I have a valid username and password and I make a post request
    Then I should receive a response with a valid token
    And I should have status code 200

  @AuthorizedUser
  Scenario: Authorize an user
    Given I have a valid token
    When I make a POST request to with my token
    Then I should receive a response indicating that I am authorized
    And Status code should be 200

  @DeleteUser
  Scenario: Delete User
    When I send a DELETE request
    Then The response status for it code should be 200
    And The response body should contain a success message indicating that the user was deleted

  @GetAllBooks
  Scenario: I want to see details about all the books
    Given I set the API endpoint as "/Books"
    When The response is received
    Then The response status code should be 200
    And The response should contain a list of all books

  @GetBookDetail
  Scenario: Get Book Details
    Given I set the API endpoint as "/Book"
    When I send a GET request with ISBN as "9781449337711"
    Then I should receive a 200 status code for it
    And The response body should contain the book details with ISBN "9781449337711"

  @AddBook
  Scenario: Add a book
    When The user adds "9781593275846" book to their list
    Then The book should be added to the user's list with status code 201

  @DeleteOneBook
  Scenario: Delete one book
    When I delete "9781593275846" book from the user's list
    Then The book should be deleted from user's list

  @DeleteAllBooks
  Scenario: Delete all books
    When I delete all books from user's list
    Then The books shouldn't be on his list anymore


