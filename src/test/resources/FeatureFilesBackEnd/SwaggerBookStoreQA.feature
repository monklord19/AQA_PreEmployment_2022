Feature: Testing APIs on swagger


   #1
  @POST_CREATE_USER
  Scenario: Create a user
    Given I have the BASE URL
    When I make a post request to create a user
    Then I receive the response for user creation

    #2
  @POST_GENERATE_TOKEN_AND_AUTHORIZED_USER
  Scenario: Generate token and authorize user
    Given I have the BASE URL
    When I make a post request to generate a token and authorized user
    Then I receive the generated token

     #3
  @POST_AUTHORIZED_USER
  Scenario: Authorized user
    Given I have the BASE URL
    When I make a post request to authorize user
    Then I should receive correct status code

     #4
  @DELETE_USERID
  Scenario: Delete userID
    Given I have the BASE URL
    When I make a detele request to delete userID
    Then I receive status for deleting userID

    #5
  @GET_USERID
  Scenario: Get user by UserId
    Given I have the BASE URL
    When I make a get request to get a user by UserId
    Then I receive the user

   #6
  @POST_BOOKS_DETAILS
  Scenario: Get books details
    Given I have the BASE URL
    When I make a post request to get the books details
    Then I receive the informations

    #7
  @POST_BOOK_TO_USER
  Scenario: Add isbn book to user
    Given I have the BASE URL
    When I make a post request to send book to a user
    Then I should see the response


    #8
  @POST_BOOK_TO_USER_BEARER_TOKEN
  Scenario: Add books details using generated token
    Given I have the BASE URL
    When  I make a post request to generate books details
    Then I receive the books details

    #9
  @DELETE_BOOK_USER
  Scenario: Delete book from user
    Given I have the BASE URL
    When I make a delete requst to delete book from user
    Then I receive the response

    #10
  @PUT_UPDATE_BOOK
  Scenario: Update book
    Given I have the BASE URL
    When I make a put request to update a book
    Then Book is updated

  #11
  @GET_ISBN
  Scenario: Get isbn
    Given I have the BASE URL
    When I make a get request to get the isbn
    Then I get isbn

  #12
  @DELETE_REQUEST_USERID
  Scenario: Delete request an USERID
    Given I have the BASE URL
    When I make a delete request
    Then Book is deleted



