Feature: ApiTests

  @GetAllUsers
  Scenario: Get all users
    Given On reqres site
    When I want to see all users
    Then Users informations are displayed
    And Status code should be equal to 200

  @GetSingleUser
  Scenario: Get single user
    Given On reqres site
    When I want to see user's informations
    Then User informations are displayed
    And Status code should be equal to 200

  @CreateNewUser
  Scenario: Create new user
    Given On reqres site
    When I create a new user
    And User is created
    Then Status code for creating user should be equal to 201

    
    @DeleteUser
    Scenario: Try to delete an user
      Given On reqres site
      When I delete user
      Then User is deleted


