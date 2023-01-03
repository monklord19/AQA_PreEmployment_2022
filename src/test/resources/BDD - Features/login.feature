@Smoke
Feature: Loggin feature

  Background:
    Given I open the webSite
  @ValidLogin
  Scenario: This is a example
    When I enter the "<userName>" and "<password>"
      | userName | password   |
      | andrei   | parola1234 |
    Then I should be logged
    And I should see an succcessfuly  popup

  @InvalidLogin
  Scenario: This is other example
    When I will enter an invalid userName and password
    Then I shouldn`t be able to login

  Scenario Outline: This is a example for outline
    Given I open other website
    When I will enter an invalid <userName> and <password>
    Then I shouldn`t be able to login
    Examples:
      | userName | password   |
      | andrei   | parola1234 |
      | istvan   | parola123  |
