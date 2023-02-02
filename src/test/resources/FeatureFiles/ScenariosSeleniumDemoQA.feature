Feature: Front End Testing - https://demoqa.com/

  Background: User selects the <Elements> section on DemoQa website

  Scenario: Testing the 'Elements' Section - Radio Button
    Given User selects the <Elements> section
    And User clicks on the <Radio Button> element
    When User selects the option <Yes>
    Then The message "You have selected Yes" is displayed


Scenario: Testing the 'Elements' Section - Text Box  //eroare la asertia nr.3!!!!
  Given  User selects the <Elements> section
  And User selects the button <Text Box> on the <Elements> section
  When User completes the fields <Full Name>, <Email>, <Current Address>, <Permanent Address>
  And User clicks on the Submit button
  Then A new box is displayed with all information previously entered.


  Scenario: Testing the 'Elements' Section - Check Box
    Given User selects the <Elements> section
    And User selects the button <Check Box> on the <Elements> section
    When User expands the Check Box List
    And User selects the options <Commands>, <Angular>, <Classified>
    Then A message "You have selected : commands angular classified" is displayed


  Scenario: Testing the 'Elements' Section - Links
    Given User selects the <Elements> section
    And User selects the <Links> section
    When User clicks on the <Moved> link that will send an api call
    Then The message "Link has responded with status 301 and status text Moved Permanently" appears

