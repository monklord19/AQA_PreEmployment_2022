Feature:Create user account, authorize user, generate a token
  Background: Setting request specifications
    Given I set request specifications

  @Account
  Scenario:Create a user account
    When I send a valid request for creating a new user
    Then User is created

  @Account
  Scenario: Authorize the user
    When I send a valid request for authorizing the user
    Then The user is authorized

  @Account
  Scenario: Generate a token
    When I send a valid request for generating a token
    Then Token is successfully generated