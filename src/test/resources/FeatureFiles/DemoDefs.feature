Feature: Final Project

  # 1
  Scenario: Submit form from DemoQa elements website
    Given On demoQA website
    When User goes to elements menu
    And Click on text box submenu
    And Complete form with "Filip Paul", "paulfilip.dev@gmail.com", "Cluj-Napoca" and "Cluj-Napoca"
    Then User should submit the form with success "true"

  # 2
  Scenario: Alerts from DemoQa alerts website
    Given On demoQA website
    When User goes to Alerts, Frame & Windows menu
    And Click on alerts submenu
    And Click on first 'Click me' button
    Then User should see an alert with the text "You clicked a button" and click 'OK' button

  # 3
  Scenario: Delay alerts from DemoQa alerts website
    Given On demoQA website
    When User goes to Alerts, Frame & Windows menu
    And Click on alerts submenu
    And Click on second 'Click me' button
    Then User should see an alert with the text "This alert appeared after 5 seconds" after 5 seconds and click 'OK' button

  # 4
  Scenario: Confirm OK selection from DemoQa alerts website
    Given On demoQA website
    When User goes to Alerts, Frame & Windows menu
    And Click on alerts submenu
    And Click on third 'Click me' button
    And User should see an alert with text "Do you confirm action?" and click ok
    Then User should see a green text "You selected Ok"

  # 5
  Scenario: Confirm CANCEL selection from DemoQa alerts website
    Given On demoQA website
    When User goes to Alerts, Frame & Windows menu
    And Click on alerts submenu
    And Click on third 'Click me' button
    And User should see an alert with text "Do you confirm action?" and click cancel
    Then User should see a green text with "You selected Cancel"

  # 6
  Scenario: Prompt box from DemoQa alerts website
    Given On demoQA website
    When User goes to Alerts, Frame & Windows menu
    And Click on alerts submenu
    And Click on the fourth 'Click me' button
    And User should see an alert with text "Please enter your name" and should complete field
    Then User should see a green text after click ok, with user name "true"

  # 7
  Scenario: Download from DemoQa elements website
    Given On demoQA website
    When User goes to elements menu
    And Click on upload and download box submenu
    And Click on download button
    Then Check if the file has been downloaded

  # 8
  Scenario: Upload on DemoQa elements website
    Given On demoQA website
    When User goes to elements menu
    And Click on upload and download box submenu
    And User click on choose file button
    Then Check if the file has been uploaded "true"

  # 9
  Scenario: Add new data to web tables
    Given On demoQA website
    When User goes to elements menu
    And Click on web tables submenu
    And Click on add button
    And User fill all fields
    Then User should be able to search his name on the list "true"
    And User wants to delete new data that he just created "true"

  # 10
  Scenario: Check double click button behavior
    Given On demoQA website
    When User goes to elements menu
    And Click on buttons submenu
    And Double click on 'Double Click Me' button
    Then User should see a confirmation message 'You have done a double click' "true"

  # 11
  Scenario: Check right click button behavior
    Given On demoQA website
    When User goes to elements menu
    And Click on buttons submenu
    And Right click on 'Right Click Me' button
    Then User should see a confirmation message 'You have done a right click' "true"

  # 12
  Scenario: Check click me button behavior
    Given On demoQA website
    When User goes to elements menu
    And Click on buttons submenu
    And Left click on 'Click Me' button
    Then User should see a confirmation message 'You have done a dynamic click' "true"

  # 13
  Scenario: Create, login and delete user via API
    Given DemoQA login website
    When Created and logged in user
    Then User has token and is authorized

  # 14
  Scenario: Login with valid credentials
    Given On demoQA website
    When User goes to bookstore menu
    And Click on login button
    And User enter valid credentials
    Then User should be logged in with success "true"

  # 15
  Scenario: Search in bookstore application
    Given User is logging in
    When User click on 'Go To Bookstore' button
    And User search a book by author
    Then User should see the result on the list

  # 16
  Scenario: Delete a single item in bookstore profile
    Given User is on the book store page
    When Click on a random book title
    And Click on 'Add to Your Collection' button
    And Click on 'ok' pop-up button
    And Click on profile submenu
    Then User should be able to delete his new single record "true"

  # 17
  Scenario: Delete all items in bookstore profile
    Given User is on the book store page
    When User adding multiple random books in the collection
    And Click on profile submenu
    Then User should be able to delete all books records "true"

  # 18
  Scenario: Logout user
    Given User is logging in
    When User click log out
    Then User should be logged out

  # 19
  Scenario: Delete account
    Given User is logging in
    When User click on delete account button
    Then User trying to reconnect with same credentials "false"

  # 20
  Scenario: Test the functionality of the slider
    Given On demoQA slider page
    When I move the horizontal slider handle to 50
    Then I should see the current value of the slider is 50









