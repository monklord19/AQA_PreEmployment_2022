
Feature: API Tests on Demo QA - Bookstore

  Scenario: Create an Authorized user
    Given User is on demoQA website
    When User creates a new user
    Then Registration is successful
    And Status Response is 200


  Scenario: Generate Token
    Given User is on demoQA website
    When Authorized user generates token
    Then Token is generated successfully
    And Status Response equals 200

  Scenario: Authorize User //correct tot scenariul
    Given User is on demoQA website
    When User makes a POST method for authorization
    Then Status Response will be 200
    And Response header will be displayed

  Scenario: Delete User
    Given User is on demoQA website
    When User deletes a user
    Then User is successfully deleted with status 200
    And Response header will appear



