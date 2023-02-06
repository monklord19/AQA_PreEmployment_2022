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

  @TextBox
  Scenario: Test Text Box
    Given User is on demoqa page
    And User clicks on Elements button
    And User clicks on Text Box button
    When User fills the text boxes
    And User clicks on Submit button
    Then The information is confirmed

  @WebTables
  Scenario: Test Web Tables
    Given User is on demoqa page
    And User clicks on Elements button
    And User clicks on Web Tables button
    When User clicks on Add button
    And User fills the registration form and clicks submit
    Then The information is successfully added

  @ClickMeButton
  Scenario: Test Links Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on Links button
    And User clicks on Home button
    Then New tab opens on demoqa page

  @BrokenLinks
  Scenario: Test BrokenLinks Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on BrokenLinks button
    And User clicks on ValidLink button
    Then New tab opens on demoqa page

  @UploadAndDownload
  Scenario: Test UploadAndDownload Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on UploadAndDownload button
    And User clicks on Download button
    Then Sample file is downloaded

  @DynamicsProperties
  Scenario: Test DynamicsProperties Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on DynamicsProperties button
    And User clicks on enableAfter button
    Then Button enableAfter is available

  @DoubleClickMeButton
  Scenario: Test DoubleClickMeButton Button
    Given User is on demoqa page
    And User clicks on Elements button
    When User clicks on Buttons button
    And User clicks on DoubleClickMeButton button
    Then You have done a double click text appears