Feature: Testing Demoqa

  @PopulateTextBoxFields
  Scenario: User populates all Text Box fields then submits them
    Given User is on Demoqa, Interactions
    When User clicks on Elements
    And User clicks on Text Box
    And Fills the form
    Then Clicks submit


  @TickExcelFile
  Scenario: User selects Excel File from Check Box submenu
    Given User is on Demoqa, Interactions tab
    When User clicks on Elements
    And User clicks on Check Box
    And Clicks to expand Home dropdown then Downloads dropdown
    Then Ticks Excel File

  @CheckRadioButton
  Scenario: User clicks yes radio button
    Given User is on Demoqa Interactions
    When User clicks on Elements
    And Clicks Radio Button
    Then Clicks Yes radio button

    @WebTablesEditCierra
    Scenario: User edits Cierras info
      Given User is on Demoqa Interactions 4
      When User clicks on Elements
      And Clicks Web Tables
      And Clicks edit
      And Fills registration form fields
      Then Clicks the submit button

