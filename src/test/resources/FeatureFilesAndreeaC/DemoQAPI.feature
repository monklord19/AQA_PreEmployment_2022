Feature: Test DemoQ Swagger

  Background:
    Given user is on DemoQ Swagger address

  @GET
  Scenario: Get Books
    When I send valid get request
    Then Books are listed

  @POST
    Scenario: Add Book with Bearer Token Authentification
    When I send post request with token and body
    Then Book isbn is listed

  @POST
  Scenario: Add Book with Basic Authentification
    When I send post request with encodedCredentials and body
    Then Book isbn is listed with basic authorisation

  @DELETE
    Scenario: Delete Book from User
    When I request to delete book from user
    Then Book is deleted successfully

  @PUT
    Scenario: Update book isbn for user
    When I send update request
    Then Book is updated
  @DELETE
    Scenario: Delete books from user
    When I sent a delete request with userId
    Then Books are deleted from userId

  @POST
  Scenario: Create user
    When I send valid request with payload
    Then User is created

    @POST
   Scenario: Confirm User Authorised
     When Send post request with user body
     Then Status response is OK

  @POST
    Scenario: Generate Token
    When I send valid request with user details
    Then Token is generated
  @GET
  Scenario: Get user by id
    When I send get user by id request
    Then User is listed

  @DELETE
  Scenario: Delete user
    When I send userId to delete
    Then User is deleted

