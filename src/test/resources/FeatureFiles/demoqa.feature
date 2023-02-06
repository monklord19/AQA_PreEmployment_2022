Feature: Demo QA Scenarios

  Scenario: Main page is properly displayed
    Given I navigate to Main Page
    When  I see the Main Page opened
    Then I see the category cards displayed

  Scenario: Category cards can be clicked
    Given I navigate to Main Page
    And  I see the Main Page opened
    When I click on the first category
    Then I can see the right page displayed

  Scenario Outline: Text is correctly entered for text boxes and submitted
    Given I navigate to Text Box page
    And I see the Text Box Page opened
    And I enter the 'Full Name': '<FullName>'
    And I enter the 'Email': "<Email>"
    And I enter the 'Current Address': "<CurrentAddress>"
    When I click submit button
    Then The output should be displayed with: '<FullName>', "<Email>", "<CurrentAddress>"

    Examples:
    | FullName      | Email                     | CurrentAddress |
    | Andrei Lapusan | andrei.lapusan@fotech.com | 123 Main St   |


  Scenario Outline: Email errors are showed when not respecting the email format
    Given I navigate to Text Box page
    And I see the Text Box Page opened
    And I enter the 'Full Name': '<FullName>'
    And I enter the 'Email': "<Email>"
    And I enter the 'Current Address': "<CurrentAddress>"
    When I click submit button
    Then The email field has errors

    Examples:
      | FullName      | Email           | CurrentAddress |
      | Andrei Lapusan | andrei.lapusan | 123 Main St   |

  Scenario: Forms can be successfully submitted
    Given I navigate to Practice Form Page
    And  I see the Practice Form Page opened
    And  I enter my First Name: "Andrei"
    And I enter my Last Name: "Lapusan"
    And I select my gender: "Male"
    And I type my phone number: "1234509876"
    When I press submit button
    Then The form was successfully submitted

  Scenario: Form is not submitted without mandatory fields filled
    Given I navigate to Practice Form Page
    And  I see the Practice Form Page opened
    When I press submit button
    Then The form was not successfully submitted

  Scenario Outline: Radio buttons work properly
    Given I navigate to Radio Button Page
    And  I see the Radio Button Page opened
    When I click on "<RadioButtonVariant>" radio button
    Then I can see the text "<RadioButtonVariant>" displayed

    Examples:
      | RadioButtonVariant  |
      | Yes                 |
      | Impressive          |


  Scenario: Double click works properly
    Given I navigate to Buttons Page
    And  I see the Buttons Page opened
    When I double click the button
    Then I can see double click message displayed

  Scenario: Right click works properly
    Given I navigate to Buttons Page
    And  I see the Buttons Page opened
    When I right click the button
    Then I can see double click message displayed
