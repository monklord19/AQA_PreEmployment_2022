Feature: Final project

  @RadioButton
  Scenario: Test Radio Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on Radio Button
    And User clicks on Yes option
    Then You have selected Yes text appears
