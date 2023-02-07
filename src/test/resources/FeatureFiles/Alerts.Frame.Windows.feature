Feature:Elements section Testing

  Background:
    Given I am on demoQa url
    And I click on Alerts,Frames & Windows section
    Scenario: Testing Alerts, prompt alert popup with sending keys
      And I click on alerts section
      When I click on click me button that opens a prompt box
      Then Prompt box that require to enter my name appears
      When I enter my name and click ok
      Then My name is successfully entered