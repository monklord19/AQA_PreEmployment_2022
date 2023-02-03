Feature: Testing Reqres
  Scenario: List all users (get method)
    Given I am on the reqres website
    When I request a list of users
    Then The users information is listed

  Scenario: See a specific user (get method)
    Given I am on the reqres website
    When I request to see a specific user's information
    Then The user is displayed

  Scenario: Create a user (post method)
    Given I am on the reqres website
    When I add a user with a specific name and job title to the users list
    Then The user is added

  Scenario: Update a user (put method)
    Given I am on the reqres website
    When I want to update a user
    Then I check that user is updated

#  Scenario: Delete a user from the list (delete method)
#    Given I am on the reqres website
#    When I want to delete a user
#    Then I check the user is deleted





