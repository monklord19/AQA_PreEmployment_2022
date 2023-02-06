Feature: Account API testing

  Scenario: POST request to create new user
    Given I am on DemoQA
    When I send a post request to create new user with username: "Adelin" and password: "Test@123"
    Then the response status code is 201

  Scenario: POST request to generate token
    Given I am on DemoQA
    When I send a post request to generate token by entering credentials
    Then I get a new token

  Scenario:  POST request for authorization
    Given I am on DemoQA
    When I send a post request to get authorized
    Then I will be authorized

  Scenario: GET request to get the user
    Given I am on DemoQA
    When I send a get request to get the user by entering id
    Then I get the specific user