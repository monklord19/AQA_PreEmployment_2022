Feature:Elements section Testing

  Background:
    Given I am on demoQa url
    And I click on elements section

  Scenario:Select radio button
    And I click on Radio Button category
    When I click on Impressive radio button
    Then A message is displayed

  Scenario:Check Box testing-for home checkbox
    And I click on CheckBox category
    When I tick the Home checkbox
    Then You have selected message is displayed

  Scenario: Text Box testing
    And I click on TextBox category
    When I input all the text fields with all valid values
    Then Submit button is clickable
    And The values that I entered are displayed

  Scenario: Web Tables testing
    And I click on Web Tables category
    When I add a User with all the necessary info
    And I click on Submit button
    And I search the User by First Name
    Then The user is displayed on the Web Table

  Scenario: Buttons-double click
    And I click on Buttons category
    When I double click on Double click me button
    Then The double click me message is displayed

  Scenario: Buttons-right click
    And I click on Buttons category
    When I right click on Right click me button
    Then The right click me message is displayed

  Scenario: Upload file testing
    And I click on Upload and Download Section
    When I upload a file
    Then File is uploaded

  Scenario: Following links with new tab open
    And I click on links section
    When I click on Home link
    Then DemoQa main page is opened




