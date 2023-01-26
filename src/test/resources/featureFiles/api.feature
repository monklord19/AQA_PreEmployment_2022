Feature: API test Reqres to Hooks

  Background:
    Given user is on API address

  Scenario: Test GET Single User status code
    When user sends a get request for user '2'
    Then user receives status code 200

  Scenario: Test GET user first name
    When user sends a get request for user '2'
    Then user receives first name:'Janet'

  Scenario: Test GET user last name
    When user sends a get request for user '2'
    Then user receives last name:'Weaver'

  Scenario: Test GET user ID
    When user sends a get request for user '2'
    Then user receives id:'2'

  Scenario: Test GET user email address
    When user sends a get request for user '2'
    Then user receives email:'janet.weaver@reqres.in'

  Scenario: Test GET user email address
    When user sends a get request for user '2'
    Then response time is under 300 miliseconds