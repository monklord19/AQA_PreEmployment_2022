Feature: Check google search functionality

  Scenario: Validaate google search is working
    Given browser is open
    And user is on google search page
    And user allow cookies
    When user enters a text in google search box
    And hits Enter
    Then user is navigated to the Search Result page
