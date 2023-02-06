Feature: Testing different functionalities of DemoQA webpage
  This features deals with verification of certain functionalities in order to see if they work properly or not

  Background:
    Given User is on 'https://demoqa.com'

    #1
     Scenario Outline: Submit users input
       Given User clicks on Elements
       When User click on Text Box
       And User field in inputs with his information "<Full Name>","<Email>","<Current Address>","<Permanent Address>"
       And User press submit button
       Then Users information should be displayed

       Examples:
       |Full Name               |Email                          |Current Address          |Permanent Address            |
       |Pitiriciu Iulian        |iulianpitiriciu4@gmail.com     |Str.Almasului nr.1 sc.2  |Str.Simion Prodan Probu nr.23|
       |Donna Gomez             |donagomez@gmail.com            |E Parkway 206            |E Parkway 206                |

       #1.1
  Scenario: Enter data from JSON file into form
    Given User clicks on Elements
    When User click on Text Box
    And I have a JSON file containing the data to be entered into the form
    And User press submit button
    Then Users information should be displayed

     #2
  Scenario: Testing alerts click buttons
    Given User is on 'https://demoqa.com/alerts'
    When First case #1 "Click Button to see alert" user clicks Click Me
    Then A pop up with You clicked a button is displayed
    When Second case #2 "On button click, alert will appear after 5 seconds" user clicks Click me
    Then A pop us with This alert appeared after 5 seconds is displayed
    When Third case #3 "On button click, confirm box will appear" user clicks Click Me
    Then A pop up with Do you confirm action? is displayed
    When Forth case #4 "On button click, prompt box will appear" user clicks Click Me
    Then A pop up with Please enter your name is displayed

    #3
  Scenario: Testing modal dialogs
    Given User is on 'https://demoqa.com/modal-dialogs'
    When User clicks on small modal button
    Then Small modal is displayed
    When User clicks on large modal button
    Then Large modal is displayed

    #4
  Scenario Outline: Upload and Downlaod
    Given User clicks on Elements
    When User clicks on Upload and Download
    Then User select "<File Path>" and upload a file
    When User selects Download
    Then User downloads a file

    Examples:

    |File Path                                                                               |
    |/Users/pitiriciuiulian/Desktop/ss.png                                                   |
    |/Users/pitiriciuiulian/Desktop/AQA_PreEmployment_Proiect_2022/src/main/resources/ss.png |

    #5
  Scenario: Hover over certain elements
    Given User is on 'https://demoqa.com/tool-tips'
    When User hovers over the first button
    Then A message is displayed
    When User types some text into text field
    Then A message is displayed
    When User hovers over the first text
    Then A message is displayed
    When User hovers over the second text
    Then A message is displayed

    #6
  Scenario: Resize box to maximum size
    Given User is on 'httpqs://demoqa.com/resizable'
    And the box has a starting size of 200x200
    And the minimum size of the box is 150x150
    And the maximum size of the box is 500x300
    When User resize the box
    Then the box should have a size of 450x300
    And the box should not be smaller than 150x150
    And the box should not be larger than 500x300

    #7
  Scenario: Drag and drop cursor style
    Given User is on 'https://demoqa.com/dragabble'
    And User selects Cursor Style
    When User drag box center box and drop it in center
    Then Center box should be located in the center of the page
    When User drag box top left and drop it in the top left of the page
    Then Top left box should be located on top left
    When User drag box bottm and drop it in the bottom of the page
    Then The bottom box should be located on bottom of the page

    #8
  Scenario: User wants to select his birth date
    Given User is on 'https://demoqa.com/date-picker'
    When User click on Select Date
    And User select month
    And User select year
    And User select day
    Then User should be able to see his date of birth

    #9
  Scenario Outline: Select a book from Book Store
    Given User is on 'https://demoqa.com/books'
    When User sorts books as Author
    And Search for Author name as "<Author name>"
    And User click on it
    Then Informations about the book is displayed
    When User sorts books as Publisher
    And Search for Publisher as "<Publisher>"
    And User perform click
    Then Information displayed

    Examples:
    |Author name      |Publisher       |
    |Axel Rauschmayer |No Starch Press |

    #10
  Scenario: Progress bar
    Given User is on 'https://demoqa.com/progress-bar'
    When User click on start button
    Then User should see the progress
    And Reset it to start again



