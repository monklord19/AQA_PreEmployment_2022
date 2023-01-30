Feature: Api tests for Reqres

  Scenario: Get all users
    Given User is on Reqres website
    When User wants to get all users
    Then All users are displayed

  Scenario: Get single user
    Given User is on Reqres website
    When User wants to get single user
    Then One user is displayed

   Scenario: Get not found user
     Given User is on Reqres website
     When User wants to get not found user
     Then Nothing is displayed because user is not found

  Scenario: Update single user
    Given User is on Reqres website
    When User wants to update one user
    Then Information for selected user is updated

  Scenario: Create single user
    Given User is on Reqres website
    When User wants to create another user
    Then User is created

  Scenario: Delete single user
    Given User is on Reqres website
    When User wants to delete another user
    Then User is deleted
