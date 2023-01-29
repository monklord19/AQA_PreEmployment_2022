Feature: Testing reqres APIs functionality

  @GET-SINGLE_USER
   Scenario: Getting single user
    Given Suppose I am an authorized user on Reqres site
    When A list of single user data is available
    And Response time and status are ok
    Then A single user is generated

    @GET_LIST_OF_USERS
    Scenario: Getting list of users
      Given Suppose I am an authorized user on Reqres site
      When Response time and status are ok
      Then List of users is generated

    @POST_CREATE_WITH_JSON
    Scenario: Create users
      Given Suppose I am an authorized user on Reqres site
      When Respons time and status are ok
      Then Users are created using JSON OBJECT

      @PUT_UPDATE_USER
      Scenario: Update users
        Given Suppose I am an authorized user on Reqres site
        When Respons time and status are ok
        Then User is updated

      @PATCH_UPDATE_USER
      Scenario: Update user
        Given Suppose I am an authorized user on Reqres site
        When Respons time and status are ok
        Then Update user complete

      @DELETE_USER
      Scenario: Delete user
        Given Suppose I am an authorized user on Reqres site
        When Respons time and status are ok
        Then User is deleted









