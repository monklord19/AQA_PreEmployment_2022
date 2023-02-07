Feature: Testing Demoqa

  @PopulateTextBoxFields
  Scenario: User populates all Text Box fields then submits them
    Given User is on Demoqa, Interactions tab
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
    Given User is on Demoqa, Interactions tab
    When User clicks on Elements
    And Clicks Radio Button
    Then Clicks Yes radio button

  @WebTablesEditCierra
  Scenario: User edits Cierras info
    Given User is on Demoqa, Interactions tab
    When User clicks on Elements
    And Clicks Web Tables
    And Clicks edit
    And Fills registration form fields
    Then Clicks the submit button

  @ButtonsRightClick
  Scenario: User selects Buttons then right clicks the 2nd button
    Given User is on Demoqa, Interactions tab
    When User clicks on Elements
    And Clicks Buttons
    And Right clicks the 2nd button
    Then A message should appear

  @LinkWillOpenNewTab
  Scenario: User selects Links then clicks Home7ndZl
    Given User is on Demoqa, Interactions tab
    When User clicks on Elements
    And Clicks Links
    And Clicks Home7ndZl
    Then The link will open in a new tab

  @DatePicker6thMarch2023
  Scenario: User selects month then day
    Given User is on Date Picker
    When Selects next month
    Then Selects day

  @MenuMainItemTwo
  Scenario: User selects Sub Sub Item 1
    Given User is on Demoqa, Interactions tab
    When User clicks on Widgets
    And Clicks on Menuu
    Then Selects Sub Sub Item 1

  @MoveSliderTo100
  Scenario: User moves the slider to 100
    Given User is on Demoqa, Interactions tab
    When User clicks on Widgets
    And Clicks on Slider
    Then Moves the slider to 100

  @SwitchControlToNewWindow
  Scenario: User switches to new window and closes it
    Given User is on Browser Windows
    When Click New Window
    Then Switches control to the new window to close it

  @BookstoreInvalidLogin
  Scenario: User enters wrong credentials then clicks Login
    Given User is on Login page
    When User enters credentials
    Then Clicks Login