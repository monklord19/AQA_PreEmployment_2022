Feature: DemoQa tests

  Background:
    Given You are on the demoQa page


  Scenario: text box test
    Given User Clicks on Text box
    And Complete the full name field with "Batman" and the email field with "Batman@gmail.com"
    And Complete the current address with "bat Cave" and  the permanent address with "Unknown"
    When Click the Submit button
    Then The information field will be displayed

  Scenario: Check box test
    Given Click on Check box
    And Click on expand all button
    When Select React, Angular,Veu
    Then The specific select message should be displayed

  Scenario: Add person in Web tables
    Given Click web tables
    And Click Add button
    And Fill the Registration form
    And Click the Submit
    When Search for  the new person in the table
    And Check if the registration was a success
    Then Click delete button for the new registration

  Scenario: Fill the practice form
    Given Click on practice form
    And Fill out the register form
    When Click submit button
   Then Check the Thanks message









