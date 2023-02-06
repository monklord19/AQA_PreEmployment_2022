Feature: Demoqa features

  Scenario: Text Box feature
    Given User is on Demoqa website
    When User clicks on Elements card
    And User clicks on Text Box from Elements category
    And User enters Full Name, Email, Current Address, Permanent Address and clicks on Submit button
    Then Output with all details is displayed

  Scenario: Check Box feature
    Given User is on Demoqa website
    When User clicks on Elements card
    And User clicks on Check Box from Elements category
    And User clicks on Home check box
    Then Message with result is displayed

  Scenario: Buttons feature
    Given User is on Demoqa website
    When User clicks on Elements card
    And User clicks on Buttons from Elements category
    And User double clicks on Double Click Me button
    Then Confirmation message that user doubled clicked on button is displayed

  Scenario: Links feature
    Given User is on Demoqa website
    When User clicks on Elements card
    And User clicks on Links from Elements category
    And User clicks on Home link
    Then New tab is opened

  Scenario: Upload feature
    Given User is on Demoqa website
    When User clicks on Elements card
    And User clicks on Upload and Download from Elements category
    And User clicks on Choose file button and selects file
    Then Name of the selected file and the path is displayed

  Scenario: Browser Windows feature
    Given User is on Demoqa website
    When User clicks on Alerts, Frame & Windows card
    And User clicks on Browser Windows from Alerts, Frame & Windows category
    And User clicks on New Window button
    Then New window is displayed

  Scenario: Alerts feature
    Given User is on Demoqa website
    When User clicks on Alerts, Frame & Windows card
    And User clicks on Alerts from Alerts, Frame & Windows category
    And User clicks on the first Click me button
    Then Alert box is displayed and user clicks on Ok button to close the alert box

  Scenario: Progress bar feature
    Given User is on Demoqa website
    When User clicks on Widgets card
    And User clicks on Progress Bar from Widgets category
    And User clicks on Start button
    Then Progress is completed and process can be reseted

  Scenario: Select Menu feature
    Given User is on Demoqa website
    When User clicks on Widgets card
    And User clicks on Select Menu from Widgets category
    And User clicks on Select Title container from Select One option and selects Mrs.
    Then Mrs. option is displayed

  Scenario: Drag and drop feature
    Given User is on Demoqa website
    When User clicks on Interactions card
    And User clicks on Droppable from Interactions category
    And User drags Drag me box and drops it on the Drop here box
    Then  Message Dropped! is displayed inside the box



