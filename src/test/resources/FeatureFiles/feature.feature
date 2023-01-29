Feature: Proiect
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

    Scenario: User edits a person's details
      Given user clicks on the Web Tables button
      And  user searches for a person by details
      And user clicks on the edit button
      And user edits a person's details
      When user clicks on submit
      Then user checks if changes have been saved

  Scenario: User opens a new tab
    Given user clicks on the Links button
    When user clicks on Home link
    Then user checks if a new tab opens

  Scenario: User uploads a file
    Given user clicks on the Upload and Download button
    And user clicks on Choose file button
    When user chooses the file
    Then message is displayed 'C:\fakepath\sampleFile.jpeg'