Feature: Test cases for the spotify website

  Background:
    Given on spotify website

    Scenario: I type in a wrong username and a password for the login option with the spotify account
      When I type the username "user" and the password "password"
      And I click on login
      Then A pop-up saying "Incorrect username or password." should appear

    Scenario: I try to log in with a invalid google account
      When I click the login with google option
      And I am on the google accounts page
      And I type in the email "alexe@gmail.com" and press Next
      Then A pop-up saying "Contul Google nu a fost găsit" should appear

    Scenario: I try to log in with a valid google account and worng password
      When I click the login with google option
      And I am on the google accounts page
      And I type in the email "alexaa@gmail.com" and press Next
      Then A new page opens up, where the text "Nu te-am putut conecta" should appear