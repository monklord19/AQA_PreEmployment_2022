@Smoke
Feature: Final Project

  @Autocomplete
    Scenario: Autocomplete the fields
    Given The user is on DemoQa page "https://demoqa.com/"
    When User is on the Widgets category
    And User access Autocomplte subcategory
    Then User type colours in the fields


  @WebTables
  Scenario Outline: Add,update and delete an employee in webtables
    Given User open the DemoQA webpage "https://demoqa.com/"
    When User open the elements category
    And User click on webtables subcategory
    And User click on add button to complete a registration form
    And User populate the field with '<firstname>','<lastname>','<emailemployee>','<age>','<salary>','<department>'
    Then User click the submit button

    Examples:
      |firstname |lastname |emailemployee        |age |salary |department         |
      |Alina     |Popa     |alinapopa@gmail.com  |29  |12345  |QaTester           |


  @Slider
  Scenario: Testing the slider functionality
    Given User access DemoQa "https://demoqa.com/"
    When User open the Widgets category
    And User scrolling the page until Slider is visible
    Then User click on the slider subcategory
    And User move the slider to the right

  @Login
  Scenario: Testing the log in
    Given User is accessing the DemoQa page "https://demoqa.com/"
    When User click on Book Store Application
    And User click on Log in
    And User enter username
    And User enter password
    And User press the login button
    Then An error message appears

  @BookStore
    Scenario: Searching for a book
    Given The user open DemoQa website "https://demoqa.com/"
    When User open BookStoreApplication
    And User type a book
    Then Check the book by author



  @CheckBox
  Scenario: Testing the checkbox
    Given User open DemoQA website "https://demoqa.com/"
    When User click on elements category
    And User click on checkbox subcategory
    And User click on expand all button
    And User check the notes box
    And User check the angular box
    And User check the general box


  @TextBox
  Scenario Outline: Populating the text box fields
    Given User is on DemoQA website "https://demoqa.com/"
    When User click on elements button
    And User click on text box subcategory
    And User enter the full name field as "<fullname>"
    And User enter the email field as "<email>"
    And User enter the current address field as "<currentaddress>"
    And User enter the permanent address field as "<permanentaddress>"
    Then User click on submit button

    Examples:
      |fullname        |email                    |currentaddress   |permanentaddress |
      |Andreea Aionesa |andreeaaionesa@gmail.com |Radna Street 22  |Radna Street 22  |

  @RadioButton
  Scenario: Testing the Radio Button
    Given The user access DemoQa "https://demoqa.com/"
    When The user access Elements category
    And User select the Radio Button subcategory
    And User select the Yes answer
    Then A message will appear with the chosen option

  @Buttons
  Scenario: Pressing the buttons
    Given User open DemoQA awebsite "https://demoqa.com/"
    When User access the Elements from homepage
    And User click the Buttons subcategory
    And User double click the first button
    Then A message will appear on the page
    And User makes a right click on the second button
    Then A message will appear
    And User make a left click on the last  button
    Then  A message will appears bellow

  @ModalDialogs
  Scenario: Testing modal dialogs
    Given User access the DemoQa page "https://demoqa.com/"
    When User click on Alerts Frame Windows category
    And User scrolling the page down
    And User open the Modal Dialogs subcategory
    And User click on Small modal button
    Then User is able to see a simple modal and press to close
    And User click on Large modal button
    Then User is able to see a bigger modal and press to close


  @Selectable
  Scenario: Testing the selectable subcategory
    Given The user is on DemoQa "https://demoqa.com/"
    When User open the interactions category
    And User click on selectable
    And User selects the first and the last label
    And User click on Grid
    Then User click one five and nine


























