Feature: Reqres ApiTests
  @GetAllUsers
  Scenario: Get All Users
      Given User is on reqres website
      When User wants to get all users
      Then Users information is displayed

  @GetSingleUser
  Scenario: Get One Single Users
    Given User is on reqres website
    When User wants to get one single user
    Then Users information is displayed

  @CreateEmployees
  Scenario: CreateEmployee
    Given User is on reqres website
    When User want to create an employee
    Then Employee is created

  @UpdateEmployees
  Scenario: UpdateEmployee
    Given User is on reqres website
    When User want to update an employee
    Then Employee is updated


  @DeleteEmployees
  Scenario: DeleteEmployee
    Given User is on website
    When User want to delete an employee
    Then Employee is deleted