Feature: Demoqa test

  Background:
    Given user is on 'https://demoqa.com/' page

  Scenario:
    When user clicks 'Element' category
    And user clicks on "Check Box" element item
    And user clicks on expand Home button
    And user clicks on 'Downloads' checkbox;
    Then message is diplayed: You have selected:'downloads'

