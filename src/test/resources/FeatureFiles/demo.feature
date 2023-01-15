Feature: Demoqa test

  Background:
    Given user is on 'https://demoqa.com/' page

  Scenario: Checkbox expand Home and select Download
    When user clicks 'Element' category
    And user clicks on "Check Box" element item
    And user clicks on expand Home button
    And user clicks on 'Downloads' checkbox;
    Then message is diplayed: You have selected:'downloads'

  Scenario: Buttons functionality
    When user clicks 'Element' category
    And user clicks on "Buttons" element item
    And user double clicks on Double Click Me button
    And user right clicks on Right Click Me button
    And user clicks on Click Me button
    Then user receives confirmation messages
