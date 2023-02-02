Feature: Front End Testing - https://demoqa.com/


  Scenario: Testing the 'Elements' Section - Radio Button on DemoQA website
    Given User selects the <Elements> section
    And User clicks on the <Radio Button> element
    When User selects the option <Yes>
    Then The message "You have selected Yes" is displayed


Scenario: Testing the 'Elements' Section - Text Box on DemoQA website
  Given User selects the button Text Box on the <Elements> section
  When User completes the fields <Full Name>, <Email>, <Current Address>, <Permanent Address>
  And User clicks on the Submit button
  Then A new box is displayed with all information previously entered.