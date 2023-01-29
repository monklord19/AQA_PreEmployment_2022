Feature:Testing a REST API

  Scenario: User wants to see list users
    Given user opens website 'https://reqres.in/'
    When user wants to get list users
    Then the response should be success

  Scenario: User wants to see single user
    Given user opens website 'https://reqres.in/'
    When user wants to get  single list
    Then the response should be success

  Scenario: User wants to create a user
    Given user opens website 'https://reqres.in/'
    When user wants to create a user
    Then the response should be '201'