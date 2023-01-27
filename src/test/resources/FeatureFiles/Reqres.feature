Feature: List all available users (get)
@GetAllUsers
  Scenario: List all users
    Given I am on the reqres website
    When I request a list of users
    Then The users information is listed


@GetSpecificUser
Feature: See a specific user (get)

  Scenario: See a specific user
    Given I am on the reqres website
    When I request to see a specific user's information
    Then The user is displayed

@PostUser
  Feature: Create and add a user to an existing list (post)

  Scenario: Add a user
    Given I am on the reqres website
    When I add a user with a specific name and job title to the users list
    Then The user is added