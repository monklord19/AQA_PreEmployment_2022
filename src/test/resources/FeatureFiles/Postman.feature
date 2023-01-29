Feature: Postman API testing

  @getAllUsers
  Scenario: Get all the users
    Given User is on
    When Clicks list users
    Then The users should appear


  @createUser
  Scenario: Create user
    Given User is on reqres
    When User clicks on create button
    Then A new user should be created

  @getUserEight
  Scenario: Get users 8 info
    Given User is on the reqres homepage
    When User clicks on get single user
    Then User 8 info should appear

  @updateUser
  Scenario: Update an user
    Given User is on reqres homepage
    When User clicks update
    Then User is updated

  @registerUser
  Scenario: Register an user
    Given User is on reqres landing page
    When User clicks register
    Then User should be registered
