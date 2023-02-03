
Feature: Front End Testing - https://demoqa.com/ - ELEMENTS

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


  Scenario: Testing the 'Widgets' Section - Tool Tips
    Given User selects the <Widgets> section
    When User clicks on the <Tool Tips> button on the <Widgets> section
    And User is hovering the button <Contrary>
    Then A success message is displayed


  Scenario: Testing the 'Widgets' Section - Accordion
    Given User selects the <Widgets> section
    When User clicks on the <Accordion> button from the <Widgets> section
    And User selects the accordion <Why do we use it?>
    Then The answer will push down


  Scenario Outline: Testing the 'Elements' Section - Text Box

    Given  User selects the <Elements> section on DemoQa homepage
    And User selects the button <Text Box>
    When User enters name in the field <Full Name>
    And User enters email in the field <Email>
    And User enters current address in the field <Current Address>
    And User enters permanent address in the field <Permanent Address>
    And User clicks on the button Submit
    Then A new box with all the entered data is displayed.
    Examples:
    |        Full Name        |       Email            |       Current Address                         |       Permanent Address     |
    |        MMC              |    test@gmail.com      |           Romania                             |            Romania          |
    |        M                |    test@yahoo.com      |     Alabama Street 121                        |            400678           |
    |Test_Name Test_FirstName |  test@outlook.com      |Alabama Street 121 Apartment 1110 Milano Italy |           Apartment 12      |



  Scenario: Testing the 'Elements' Section - Web Tables
    Given User selects the <Elements> section
    And User clicks on the <Web Tables> button from the <Elements> section
    When User user clicks on the button "Add"
    And User adds valid First Name,Last Name, Email, Age, Salary and Department
    And user clicks the button "Submit"
    Then A new row is added to the table


