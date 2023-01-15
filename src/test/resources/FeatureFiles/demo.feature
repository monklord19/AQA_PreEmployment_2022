Feature: Demoqa test

  Background:
    Given user is on 'https://demoqa.com/' page

  Scenario: Checkbox expand Home and select Download
    When user clicks on 'Element' category
    And user clicks on "Check Box" element item
    And user clicks on expand Home button
    And user clicks on 'Downloads' checkbox;
    Then message is diplayed: You have selected:'downloads'

  Scenario: Buttons functionality
    When user clicks on 'Element' category
    And user clicks on 'Buttons' element item
    And user double clicks on Double Click Me button
    And user right clicks on Right Click Me button
    And user clicks on Click Me button
    Then user receives confirmation messages

  Scenario Outline: Web Tables add, edit and erase lines
    When user clicks on 'Element' category
    And user clicks on 'Web Tables' element item
    And user clicks on Add button
    And user fills with: '<firstName>','<lastName>','<email>','<age>','<salary>','<department>' the registration form
    And user clicks submit button
    And user clicks the edit button from the first line
    And user edits the age
    And user clicks submit button
    And user
    Examples:
      | firstName |  | lastName |  | email                 |  | age |  | salary |  | department |
      | Radu      |  | Sabau    |  | sabau.radu91@yahoo.ro |  | 31  |  | 15000  |  | Technical  |
