@Smoke
Feature: Login feature

  Background:
    Given I open the website

  @ValidLogin
  Scenario: Login with valid credentials
    When I enter the "<userName>" and "<password>"
      | userName | password   |
      | raluca   | pass1234   |
    Then I should be logged
    And I should see an successfully popup

  @InvalidLogin
  Scenario: Login with valid userName and blank password
    When I will enter an valid userName and blank password
    Then I shouldn't be able to login

  @InvalidLogin
  Scenario: Login with blank userName and valid password
    When I will enter a blank userName and valid password
    Then I shouldn't be able to login

  @InvalidLogin
  Scenario: Login with invalid userName and valid password
    When I will enter an invalid userName and valid password
    Then I shouldn't be able to login

  @InvalidLogin
  Scenario: Login with valid userName and invalid password
    When I will enter a valid userName and invalid password
    Then I shouldn't be able to login

  Scenario Outline: Login with multiple valid credentials
    Given I open other website
    When I will enter an valid "<userName>" and "<password>"
    Then I should be able to login
    Examples:
      | userName | password   |
      | raluca   | pass1234   |
      | maria    | pass1234   |

  Scenario Outline: Login with multiple invalid credentials
    Given I open other website
    When I will enter an invalid "<userName>" and "<password>"
    Then I shouldn't be able to login
    Examples:
      | userName | password   |
      | rulaca   | pass4567   |
      | miraa    | pass4567   |

