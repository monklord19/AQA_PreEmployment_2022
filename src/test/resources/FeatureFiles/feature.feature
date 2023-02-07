Feature: Demoqa Proiect

  Scenario: Text Box
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Text Box
    And User fills Full Name , Email, Current Address, Permanent Address box
    And User click Submit button
    Then Confirmation of introduced datas

  Scenario: Check Box
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Check Box
    And User clicks on Home
    Then You have selected home desktop notes commands appears

  Scenario: Radio Button
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Radio Button
    And User clicks on Yes
    Then You have selected Yes

  Scenario: Check radio button
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Radio Button
    When User selects impressive radio button
    Then check label is displayed correctly

  Scenario: Buttons Click Me
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Buttons
    Then User clicks on Click me button

  Scenario: Alerts Browser Windows
    Given User is on demoqa page browser windows
    When User clicks on New Window Message
    Then User is on New Window

  Scenario: Alerts Button to see alert
    Given User is on demoqa page Alerts, Frame & Window
    When User clicks Alerts
    Then User clicks Button to see alert

  Scenario: Interactions Droppable
    Given User is on demoqa page Interactions and Droppable element
    When User clicks on Simple drag box into drop box
    Then User Dropped

  Scenario: Book Store Application Login
    Given User is on demoqa Bookstore
    When User enters credentials
    And User clicks submit button
    Then Error message is displayed

  Scenario: Elements Download
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Upload and Download
    And User selects Download
    Then User downloaded sample File

  Scenario: Elements Upload
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Upload and Download
    Then User selects Choose File

  Scenario: Check radio button
    Given User is on demoqa page
    When User clicks on Elements button
    And User clicks on Radio Button
    When User selects impressive radio button
    Then check label is displayed correctly




Scenario:




















