Feature: Test Api Reqres
  Background:
    Given user is on API address

  @POST_CreateUser
  Scenario: Create user
    When I send valid request with payload
    Then User is created

  @GET_GetUser
  Scenario: Get single user
    When I send a get user by id request
    Then User is listed

  @PUT_UpdateUser
  Scenario: Update user
    When I send valid body
    Then User is updated

  @PATCH_UpdateUser
  Scenario: Update user with patch
    When I send valid patch request and body
    Then User is updated

  @DELETE_User
  Scenario: Delete user
    When I send delete request
    Then User is deleted

  @POST_RegisterSuccessful
  Scenario: Register Successful
    When I send valid credentials
    Then I am successfully registered

  @GET_GetUserNotFound
  Scenario: Get user, not found
    When I send a get user by wrong id
    Then Messege not found is displayed

  @GET_GetListResource
  Scenario: Get list resource
    When I send a get list resource request
    Then List is displayed

  @GET_GetSingleResource
  Scenario: Get single resource
    When I send a get single resource request
    Then Resource is displayed

  @GET_GetUsers
  Scenario: Get all users
    When I send a get request
    Then All users displayed