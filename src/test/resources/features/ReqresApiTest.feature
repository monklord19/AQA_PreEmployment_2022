Feature: Reqres Testing


  Scenario: GET all users Request
    Given User opens the reqres.in homepages
    When User wants to list all the users
    Then Status Code equals 200


  Scenario: GET one single user Request
    Given User opens the reqres.in homepage
    When User wants to list one single user
    Then Status Code is 200



  Scenario: PUT Request
    Given User is opening the reqres.in homepage
    When User wants to use the PUT method and update a user
    Then The new user is successfully updated


  Scenario: POST Request
    Given User opens the reqres.in page
    When User wants to create one user using the POST method
    Then The new user is successfully created


  Scenario: DELETE Request
    Given User opens the reqres.in website
    When User wants to delete one user using the DELETE method
    Then The user is successfully deleted


  Scenario: GET one single user Request
    Given User opens the reqres.in web page
    When User wants to list one user
    Then Response equals 200
    And Single user contains "janet.weaver@reqres.in" as email

  Scenario: POST Request
    Given User opens the reqres page
    When User wants to create one user with the POST method
    Then The new user is created



