Feature: Demoqa test

  Scenario: Checkbox expand Home and select Download
    Given user clicks on 'Element' category
    When user clicks on "Check Box" element item
    And user clicks on expand Home button
    And user clicks on 'Downloads' checkbox;
    Then message is displayed: You have selected:'downloads'

  Scenario: Buttons functionality check
    Given user clicks on 'Element' category
    When user clicks on 'Buttons' element item
    And user double clicks on Double Click Me button
    Then user receives Double Click confirmation messages
    When user right clicks on Right Click Me button
    Then user receives Right Click confirmation messages
    When user clicks on Click Me button
    Then user receives Click confirmation messages

  Scenario Outline: Web Tables add, edit and erase lines
    Given user clicks on 'Element' category
    When user clicks on 'Web Tables' element item
    And user clicks on Add button
    And user fills with: '<firstName>','<lastName>','<email>','<age>','<salary>','<department>' the registration form
    And user clicks submit button
    Then new line with: '<firstName>','<lastName>','<email>','<age>','<salary>','<department>' is registered
    When user clicks the edit button from the first line
    And user edits the age with '40' years
    And user clicks submit button
    Then age at first line is edited at '40'
    When user clicks delete button on second line
    Then "Alden"'s line is erased
    Examples:
      | firstName |  | lastName |  | email                 |  | age |  | salary |  | department |
      | Radu      |  | Sabau    |  | sabau.radu91@yahoo.ro |  | 31  |  | 11000  |  | Technical  |

  Scenario Outline: Upload a file
    Given user clicks on 'Element' category
    When user clicks on 'Upload and Download' element item
    And user enters '<Path>'
    Then file name 'FirstWeek.txt' and path of document uploaded is displayed
    Examples:
      | Path                     |
      | \HomeWorks\FirstWeek.txt |

  Scenario: Getting the texts from the outer and inner frames
    Given user clicks on 'Alerts, Frame & Windows' category
    When user clicks on 'Nested Frames' element item
    Then user gets and print the outer frame text:'Parent frame'
    And user gets and print the inner frame text:'Child Iframe'

  Scenario: Alerts functionality check
    Given user clicks on 'Alerts, Frame & Windows' category
    When user clicks on 'Alerts' element item
    And user clicks on the simple alert button to open it
    Then user gets the alert message and close it with OK
    When user clicks on the timer alert button to open it
    Then user gets the timer alert message and close it with OK
    When user clicks on the confirm alert button to open it
    Then user gets the confirm alert message and close it with Cancel
    When user clicks on the prompt alert button to open it
    Then user gets the prompt alert, write 'Radu' and close it with OK

  Scenario: Add date in Date Picker fields
    Given user clicks on 'Widgets' category
    When user clicks on 'Date Picker' element item
    Then user adds 15 days from current date in first date field
    And user adds 15 days and 3 hours from current date in seconds date field

  Scenario: Drag and drop simple action
    Given user clicks on 'Interactions' category
    When user clicks on 'Droppable' element item
    And user clicks on Simple button
    And user drag box and drop it on drop box
    Then user receives confirmation message on drop box:'Dropped!'

  Scenario: Select multiple items from a vertical list
    Given user clicks on 'Interactions' category
    When user clicks on 'Selectable' element item
    And user clicks 'List' button
    And user clicks 'Dapibus ac facilisis in'
    Then 'Dapibus ac facilisis in' item is active

  Scenario: Select value, tile and old style menus functionality
    Given user clicks on 'Widgets' category
    When user clicks on 'Select Menu' element item
    And user clicks on select value option
    And user selects value 'Another root option'
    Then 'Another root option' value is selected
    When user clicks on select one value option
    And user selects value 'Mr.'
    Then 'Mr.' one value is selected
    When user selects color 'Blue' in old style select menu
    Then color 'Blue' is selected
