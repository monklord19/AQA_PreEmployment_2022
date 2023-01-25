Feature: Proiect
  Background: User opens https://demoqa.com/
    Given user opens website

  Scenario: User completes a form
    Given User clicks on the 'Elements' button
    And User clicks on the 'Text Box' button
    And user completes the form
    When user clicks on submit
    Then the user form should appear

  Scenario: User checks 'Office' checkbox
    Given user clicks on the 'Elements' button
    And user clicks on the 'Check Box' button
    When user clicks on the 'Home' expand button
    And user clicks on the 'Documents' expand button
    And user checks 'Office' checkbox
    Then message is displayed "You have selected :office public private classified general"