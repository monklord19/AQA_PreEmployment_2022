
Feature: Front End Testing - https://demoqa.com/

  Scenario: Scenario No. 1 - Testing the Radio Button element - Elements/Radio Button
    Given User selects the <Elements> section
    And User clicks on the <Radio Button> element
    When User selects the option <Yes>
    Then The message "You have selected Yes" is displayed


Scenario: Scenario No. 2 - Testing the Text Box element - Elements/Text Box
    Given  User selects the <Elements> section
    And User selects the button <Text Box> on the <Elements> section
    When User completes the fields <Full Name>, <Email>, <Current Address>, <Permanent Address>
    And User clicks on the Submit button
    Then A new box is displayed with all information previously entered.


  Scenario: Scenario No. 3 - Testing the Check Box element - Elements/Check Box
    Given User selects the <Elements> section
    And User selects the element <Check Box>
    When User clicks the check box button <Home>
    Then A response message appears on the page


  Scenario: Scenario No. 4 - Testing the Links element - Elements/Links
    Given User selects the <Elements> section
    And User selects the <Links> section
    When User clicks on the <Moved> link that will send an api call
    Then The message "Link has responded with status 301 and status text Moved Permanently" appears


  Scenario: Scenario No. 5 - Testing the Tool Tips widget - Widgets/Tool Tips
    Given User selects the <Widgets> section
    When User clicks on the <Tool Tips> button on the <Widgets> section
    And User is hovering the button <Contrary>
    Then A success message is displayed


  Scenario: Scenario No. 6 - Testing the Accordion widget - Widgets/Accordion
    Given User selects the <Widgets> section
    When User clicks on the <Accordion> button from the <Widgets> section
    And User selects the accordion <Why do we use it?>
    Then The answer will push down


  Scenario Outline: Scenario No. 7 - Testing the Text Box element - Elements/Text Box

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



  Scenario: Scenario No. 8 - Testing the Web Tables element - Elements/Web tables
    Given User selects the <Elements> section
    And User clicks on the <Web Tables> button from the <Elements> section
    When User user clicks on the button "Add"
    And User adds valid First Name,Last Name, Email, Age, Salary and Department
    And user clicks the button "Submit"
    Then A new row is added to the table


  Scenario: Scenario No. 9 - Testing the Web Tables element - Elements/Web tables/Actions/Delete
    Given User selects the <Elements> section on the homepage
    And User clicks on the <Web Tables> button
    When User clicks the button "Add"
    And User adds First Name,Last Name, Email, Age, Salary and Department
    And User clicks the Submit button
    And User clicks the Delete button
    Then The record is deleted


  Scenario: Scenario No. 10 - Testing the Buttons element - Elements/Buttons
    Given User selects the <Elements> section
    When User clicks on the <Buttons> element
    And User clicks on the button <Double Click Me>
    Then A response message is displayed


  Scenario: Scenario No. 11 - Testing the Tabs widget - Widgets/Tabs
    Given User selects the <Widgets> section
    When User clicks on the <Tabs> tab from the <Widgets> section
    And User clicks the tab <Origin>
    Then A response message appears on the screen








