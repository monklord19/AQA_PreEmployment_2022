Feature: Demo Site
  Background:
    Given user is on demo main page

  Scenario: double click button test
    When user clicks 'Forms' button
    And user scrolls down
    And user clicks on "Buttons" element
    And user double clicks on double-click button
    Then user receives message
    And the message is: 'You have done a double click'