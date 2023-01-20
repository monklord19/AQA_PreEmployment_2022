Feature: Final project

  @RadioButton
  Scenario: Test Radio Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on Radio Button
    And User clicks on Yes option
    Then You have selected Yes text appears

  @CheckBox
  Scenario: Test Check Box
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on Check Box
    And User clicks on Home Check Box
    Then You have selected Home Desktop appears

  @ClickMeButton
  Scenario: Test Click Me Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on Buttons button
    And User clicks on Click Me button
    Then You have done a dynamic click text appears
