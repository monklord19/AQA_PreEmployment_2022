Feature: DemoQA testing QA tools

  Scenario: DemoQA first page
      Given User is on DemoQA page
      When User clicks on Elements button
      And User clicks on Check Box
      And User check the home box
      Then Text will be shown

  Scenario: DemoQA Text Box
      Given User is on DemoQA elements page
      When User clicks on Text Box button
      And User enters Name, Email, Current Address & Permanent Address
      And User clicks on Submit
      Then The data will appear below

  Scenario: DemoQA Radio Button
      Given User is on DemoQA elements page
      When User clicks on Radio Button
      And User clicks on Yes
      Then Text You have selected Yes will appear

  Scenario: DemoQA Text Box Right Click
      Given User is on DemoQA elements page
      When User clicks on Buttons button
      And User clicks on Right Click Me button
      Then Text You have done a right click will appear

  Scenario: DemoQA Text Box Double Click
    Given User is on DemoQA elements page
    When User clicks on Buttons button
    And User clicks on Double Click Me button
    Then Text You have done a double click will appear

  Scenario: DemoQA Windows new tab
    Given User is on DemoQA browser windows page
    When User click on New Tab Button
    Then A sample page will open on new tab

  Scenario: DemoQA Alerts
      Given User is on DemoQA alerts
      When User clicks on button to open a new alert
      Then Alert will appear at the top of the page

  Scenario: DemoQA Alerts prompt
    Given User is on DemoQA alerts
    When User clicks on button to open a new alert with a prompt
    And User enter some text on alert
    Then Alert will close
    And Text You entered will appear on the alerts page

  Scenario: DemoQA Alerts confirm box
    Given User is on DemoQA alerts
    When User clicks on button to open a new alert with confirm box
    And User accept the alert
    Then Text You selected Ok will appear on page


  Scenario: DemoQA Widgets
      Given User is on DemoQA Widgets slider
      When User will hold click and drag the blue circle
      Then The value will increment or decrement

  Scenario: DemoQA Book Store Application
      Given User is on Login
      When User enters credentials
      And User clicks on Login button
      Then Invalid username or password message will appear

  Scenario: DemoQA Interactions Dropable
    Given User is on Droppable
    When User drag and drop the Drag me box into Drop here box
    Then User will be dropped

  Scenario: DemoQA Interactions Sortable
    Given User is on sortable
    When User drag and drop the sorted list
    Then User will change the order of the list

