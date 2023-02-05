Feature: Test DemoQ examples
  Background: I am on Demoq webpage

  Scenario: Verify checkbox
    Given I am on CheckBox page
    When I click plus to see more
    And I select Classified folder
    Then Green message appears


  Scenario: Exercise Select Menu
    Given I am on Select menu page
    When I select multi options
    Then Options are displayed

  Scenario: Fill the form
    Given I am on TextBox page
    When I fill all text boxex
    And Click submit button
    Then My form is displayed

  Scenario: Verify Buttons
    Given I am on buttons page
    When I perform all tipes of click
    Then Messege is displayed

  Scenario: Verify Radio Buttons
    Given I am on Radio Buttons page
    When I select Impressive button
    Then Message Impressive is displayed


  Scenario: Verify upload-download page
    Given I am on upload-download page
    When I click download button
    And I click upload button,I select file and click open
    Then File is downloaded and uploaded

  Scenario: Verify Progress-bar
    Given I am on Progress bar page
    When I click start button
    And I wait for progressing
    Then Progress bar is finished and reseted

  Scenario: Verify Slider element
    Given I am on Slider page
    When I click and move slider
    Then I go to end of slider

  Scenario: Verify Accordian Page
    Given I am on Accordian menu page
    When I click on first section
    And I click on second section
    And I click on third section
    Then Message for third section is displayed

  Scenario: Verify Alerts page
    Given I am on Alerts page
    When I click on alert button
    And I click on timer alert button
    And I click on confirm button
    And I click on prompt button and send my name
    Then I check message alert displayed


