Feature: API test Reqres to Hooks

  Background:
    Given user is on API address

  Scenario: Test GET single user status code
    When user sends a get request for user '2'
    Then user receives status code 200

  Scenario: Test GET single user first name
    When user sends a get request for user '2'
    Then user receives first name:'Janet'

  Scenario: Test GET single user last name
    When user sends a get request for user '2'
    Then user receives last name:'Weaver'

  Scenario: Test GET single user ID
    When user sends a get request for user '2'
    Then user receives id:'2'

  Scenario: Test GET single user email address
    When user sends a get request for user '2'
    Then user receives email:'janet.weaver@reqres.in'

  Scenario: Test GET single user email address
    When user sends a get request for user '2'
    Then response time is less than 300 milliseconds

  Scenario: Test GET single user not found status code
    When user sends a get request for user '23'
    Then user receives status code 404

  Scenario: Test GET list resources status code
    When user sends a get request list resources for page 1
    Then user receives status code 200

  Scenario: Test GET list resources page number
    When user sends a get request list resources for page 1
    Then user receives number of page and is: '1'

  Scenario: Test GET list resources number of users on page
    When user sends a get request list resources for page 1
    Then user receives number of users on this page and is: '6'

  Scenario: Test GET list resources number of users on page
    When user sends a get request list resources for page 1
    Then user receives the total number of pages and is: '2'

  Scenario: Test DELETE user status code
    When user sends delete request for user number: '2'
    Then user receives status code 204

  Scenario: Test POST create new user status code
    When user sends post request with new name and job
    Then user receives status code 201




