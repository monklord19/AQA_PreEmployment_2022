Feature: on demoqa site
  Scenario: Check radio
    Given On demo site
    When User selects Impressive radio button
    Then check label is displayed correctly