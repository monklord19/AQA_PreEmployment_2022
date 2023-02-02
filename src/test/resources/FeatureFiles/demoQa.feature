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
    Then Check if the registration was a success

  Scenario: Fill the practice form
    Given Click on practice form
    And Fill out the register form
    When Click submit button
    Then Check the Thanks message

  Scenario: Double click the button in the Buttons section
    Given Click on the Buttons btn
    When Double click the Double Click Me button
    Then Check for the double click message

  Scenario: Slider test
    Given Click on Widgets link
    When Move the slider at 50
    Then Check  for the number 50

  Scenario: Auto Complete test
    Given Click on Auto complete in widgets
    When  Fill the Type multiple color field with "Red" and "Yellow"
    And Fill theType single color field with "Blue"
    Then Check the field for the colors

  Scenario: Hover over main item 2 test
    Given Click on Menu button
    When Hover over main item 2
    And Hover over SUB SUB LIST
    Then Make sure Sub Sub item 2 is displayed

  Scenario: Select Menu test
    Given Click on Select menu button
    When Complete all the fields
    Then Check select field for to have "Group 2, option 2" and old style menu to have the color "Yellow"

    Scenario: Droppable test
      Given Click on droppable button
      When Drag the drag me box in the Drop here box
      Then Check for the draggable to hover over the box