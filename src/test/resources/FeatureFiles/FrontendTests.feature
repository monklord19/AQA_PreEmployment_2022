Feature: Proiect Final - Frontend
  Background: User opens https://demoqa.com/
    Given user opens website
    And user clicks on the Elements button

  Scenario: User completes a form
    Given user clicks on the Text Box button
    And user completes the form
    When user clicks on submit
    Then user's details should appear

  Scenario Outline: User checks 'Office' checkbox
    Given user clicks on the Check Box button
    When user clicks on the Home expand button
    And user clicks on the Documents expand button
    And user checks <toCheck> checkbox and uncheck <toUncheck> checkbox
    Then message is displayed <message>
    Examples:
      | toCheck  | toUncheck    |      message                                              |
      | 'office' | 'classified' |      'You have selected :\npublic\nprivate\ngeneral'      |
      | 'office' | 'general'    |      'You have selected :\npublic\nprivate\nclassified'   |

  Scenario Outline: User edits a person's details
    Given user clicks on the Web Tables button
    And user searches for a person by <name>
    And user clicks on the edit button
    And user edits a person's details
    When user clicks on submit
    Then user checks if changes have been saved
    Examples:
      | name     |
      | 'Cierra' |


  Scenario: User opens a new tab
    Given user clicks on the Links button
    When user clicks on Home link
    Then user checks if a new tab opens


  Scenario: User uploads a file
    Given user clicks on the Upload and Download button
    And user clicks on Download file button
    When user chooses the file
    Then user checks if file is uploaded

    Scenario: User checks alerts feature
      Given user clicks on the Alerts button
      When user clicks on Click me button for confirm box
      And user checks if alerts appear
      And user clicks on Click me button for prompt box
      Then user enters their name
      And user checks if message is displayed

  Scenario Outline: User checks autocomplete feature
    Given user clicks on the autocomplete button
    When user enters first part of <color> and <color1> in first input
    And user enters first part of <color2> in second input
    Then uesr checks if coresponding color is selected

    Examples:
      | color     |  color1    |   color2    |
      | 'Red'     |  'Green'   |  'Yellow'   |
      | 'Purple'  |  'Blue'    |  'Magenta'    |


    Scenario: User checks slider feature
      Given user clicks on the Slider button
      When user moves slider
      Then user checks if the slider is moved

    Scenario: User checks selectable feature
      Given  user clicks on the Selectable button
      When user selects odd labels
      Then user checks if the labels is selected

    Scenario Outline: User checks droppable feature
      Given user clicks on Droppable button
      When user drags the <tag> to drop area
      Then user checks if the element is accepted or not
      Examples:
        |    tag            |
        |  'acceptable'     |
        |  'notAcceptable' |
