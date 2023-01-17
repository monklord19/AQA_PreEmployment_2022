Feature: Demoqa test

  Background:
    Given user is on 'https://demoqa.com/' page

  Scenario: Checkbox expand Home and select Download
    When user clicks on 'Element' category
    And user clicks on "Check Box" element item
    And user clicks on expand Home button
    And user clicks on 'Downloads' checkbox;
    Then message is diplayed: You have selected:'downloads'

  Scenario: Buttons functionality check
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
    And new line with: '<firstName>','<lastName>','<email>','<age>','<salary>','<department>' is registered
    And user clicks the edit button from the first line
    And user edits the age with '40' years
    And user clicks submit button
    And age at first line is edited at '40'
    And user clicks delete button on second line
    And "Alden"'s line is erased
    Examples:
      | firstName |  | lastName |  | email                 |  | age |  | salary |  | department |
      | Radu      |  | Sabau    |  | sabau.radu91@yahoo.ro |  | 31  |  | 11000  |  | Technical  |

  Scenario Outline: Upload a file
    When user clicks on 'Element' category
    And user clicks on 'Upload and Download' element item
    And user enters '<Path>'
    And file name 'FirstWeek.txt' and path of document uploaded is displayed
    Examples:
      | Path                                                                                                     |
      | C:\Users\Radu Sabau\Desktop\AQA-Pre-Employment\AQAProject\AQA_PreEmployment_2022\HomeWorks\FirstWeek.txt |

  Scenario: Geting the texts from the outer and inner frames
    When user clicks on 'Alerts, Frame & Windows' category
    And user clicks on 'Nested Frames' element item
    And user gets and print the outer frame text:'Parent frame'
    And user gets and print the inner frame text:'Child Iframe'

  Scenario: Alerts functionality check
    When user clicks on 'Alerts, Frame & Windows' category
    And user clicks on 'Alerts' element item
    And user clicks on the simple alert button to open it and close it with OK
    And user clicks on the timer alert button to open it and close it with OK
    And user clicks on the confirm alert button to open it and close it with Cancel
    And user clicks on the prompt alert button to open it, write 'Radu' and close it with OK