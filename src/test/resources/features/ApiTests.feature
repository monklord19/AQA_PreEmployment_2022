Feature: ReqresApi tests


  Scenario: Get all users api test
    Given On the reqres page
    When Gets the users
    Then Status code is 200


  Scenario: Create user test
    Given On the reqres page
    When User is created
    Then Check user is created

  Scenario: Update user test
    Given On the reqres page
    When User is updated
    Then check updated user

  Scenario: Partially update user test
    Given On the reqres page
    When Update name
    Then Check the partially update

  Scenario: Delete the user test
    Given On the reqres page
    When delete the user
    Then Check status code