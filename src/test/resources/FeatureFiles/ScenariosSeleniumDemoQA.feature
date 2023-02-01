Feature: Front End Testing - https://demoqa.com/


  Scenario: Testing the 'Elements' Section - Radio Button on DemoQA website
    Given User selects the <Elements> section
    And User clicks on the <Radio Button> element
    When User selects the option <Impressive>
    Then The message: "You have selected Impressive" is displayed


Scenario: Testing the 'Elements' Section - Text Box on DemoQA website
  Given User selects the button Text Box on the Elements page
  When User completes all the required fields
  And User clicks on the Submit button
  Then A new box is displayed with all information entered previously.