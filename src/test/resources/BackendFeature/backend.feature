Feature: Test DemoQA API

  Background:
    Given User is on DemoQA Swagger

  @POST
  Scenario: Post Account User
    When User sent a post request to create an user
    Then The response will be with username and password

  @POST
  Scenario: Post Account Authorized
    When User sent a post request to confirm user authorised
    Then The response will be with body

  @POST
  Scenario: Post Account Generate Token
    When User sent a post request to generate token
    Then The response will be with the body

  @DELETE
    Scenario: Delete Account User
    When Delete an user by userdId
    Then User will be deleted

  @GET
  Scenario: Get Account User
    When Send a request to get user by Id
    Then User appears

  @GET
  Scenario: Get BookStore Books
    When Send a request to get the books
    Then The books are listed

  @POST
  Scenario: Post BookStore Book
    When User sent a request to create a book
    Then The book is created

  @DELETE
  Scenario: Delete BookStore Books
    When User sent a request to delete the books
    Then The books are deleted

  @GET
  Scenario: Get BookStore Book
    When User sent a request to get a book
    Then The book is listed

  @DELETE
  Scenario: Delete BookStore Books
    When User sent a request to delete books from inventory
    Then The books are deleted from inventory


