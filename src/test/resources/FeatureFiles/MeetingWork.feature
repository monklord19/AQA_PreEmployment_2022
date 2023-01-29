Feature: Testing reqres APIs functionality
  Scenario: List of users
    Given Getting list of users from reqres site
    When Respons time and status are ok
    Then A single user is extracted


  Scenario: Create user
    Given Creating users on reqres site
    When Response time and status are ok
    Then User is created