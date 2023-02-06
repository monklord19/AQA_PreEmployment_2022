
Feature: Front End Testing - https://demoqa.com/

  Scenario: Scenario No. 1 - Testing the Radio Button element - Elements/Radio Button    //correct
    Given User selects the <Elements> section
    And User clicks on the <Radio Button> element
    When User selects the option <Yes>
    Then The message "You have selected Yes" is displayed


Scenario: Scenario No. 2 - Testing the Text Box element - Elements/Text Box      //correct
    Given  User selects the <Elements> section
    And User selects the button <Text Box> on the <Elements> section
    When User completes the fields <Full Name>, <Email>, <Current Address>, <Permanent Address>
    And User clicks on the Submit button
    Then A new box is displayed with all information previously entered.


  Scenario: Scenario No. 3 - Testing the Check Box element - Elements/Check Box       //correct
    Given User selects the <Elements> section
    And User selects the element <Check Box>
    When User clicks the check box button <Home>
    Then A response message appears on the page


  Scenario: Scenario No. 4 - Testing the Links element - Elements/Links   //correct
    Given User selects the <Elements> section
    And User selects the <Links> section
    When User clicks on the <Moved> link that will send an api call
    Then The message "Link has responded with status 301 and status text Moved Permanently" appears


  Scenario: Scenario No. 5 - Testing the Tool Tips widget - Widgets/Tool Tips    // error:User is hoovering the button <Contrary>
    Given User selects the <Widgets> section
    When User clicks on the <Tool Tips> button on the <Widgets> section
    And User is hovering the button <Contrary>
    Then A success message is displayed


  Scenario: Scenario No. 6 - Testing the Accordion widget - Widgets/Accordion   //Scenario 6 - error:User clicks on the <Accordion> button
    Given User selects the <Widgets> section
    When User clicks on the <Accordion> button from the <Widgets> section
    And User selects the accordion <Why do we use it?>
    Then The answer will push down


  Scenario Outline: Scenario No. 7 - Testing the Text Box element - Elements/Text Box      //eroare asertie

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



  Scenario: Scenario No. 8 - Testing the Web Tables element - Elements/Web tables  - correct
    Given User selects the <Elements> section
    And User clicks on the <Web Tables> button from the <Elements> section
    When User user clicks on the button "Add"
    And User adds valid First Name,Last Name, Email, Age, Salary and Department
    And user clicks the button "Submit"
    Then A new row is added to the table


  Scenario: Scenario No. 9 - Testing the Web Tables element - Elements/Web tables/Actions     Scenario 9 - eroare asertie
    Given User selects the <Elements> section
    And User clicks on the <Web Tables> button from the <Elements> section
    When User user clicks on the button "Add"
    And User adds valid First Name,Last Name, Email, Age, Salary and Department
    And user clicks the button "Submit"
    Then User clicks the Edit button
    And User modifies the Email and clicks the Submit button
    And checks if the email was successfully updated on the table


  Scenario: Scenario No. 10 - Testing the Buttons element - Elements/Buttons
    Given User selects the <Elements> section
    When User clicks on the <Buttons> element
    And User clicks on the button <Click Me>
    Then A response message is displayed


  Scenario: Scenario No. 11 - Testing the Date Picker widget - Widgets/Date Picker
    Given User selects the <Widgets> section
    When User clicks on the <Date Picker> button from the <Widgets> section
    And User clicks on the button <Select Date> and <Date And Time>
    Then Selection is successful








