Feature: ReqresApi tests

  Scenario: Get all users apiTest
    Given On the Reqres website
    When Gets the users
    Then Status code should be 200

  Scenario: Create user test
    Given On the Reqres website
    When An user is created
    Then Check if the user is created

  Scenario: Update user test
    Given On the Reqres website
    When An user is updated
    Then Check the updated user

  Scenario: Delete the user test
    Given On the Reqres website
    When An user is deleted
    Then Check the status code