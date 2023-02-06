Feature: Testing Interactions

  Background:
    Given I am on demoQa url
    And I click on Interactions section

  Scenario: testing resizable box without restrictions
    And I go to Resizable section
    When I resize the box without restrictions
    Then The box is resized

  Scenario:Testing droppable section-simple
    And I click on droppable section
    When I perform drag and drop action
    Then drag me element is successfully moved to drop element

