Feature: Login with google and spotify account
  This feature deals with 3 login functionalities of Spotify webpage
  Background: I open Spotify webpage https://open.spotify.com/

    @InvalidLogin
    Scenario: Login with invalid Spotify credentials
      Given User navigates to Spotify "https://open.spotify.com/"
      And User accepts cookies
      And User click on Log in button
      When User types username as "test123" and password as "password123"
      And User clicks Log in with Spotify
      Then  Error message pops up as "Incorrect username or password."


    @InvalidLogin
    Scenario: Login with google account and invalid google credentials on Spotify website
      Given User navigates to Spotify "https://open.spotify.com/"
      And User accepts cookies
      And User click on Log in button
      When User clicks on Continue with Google
      And User types emailAdress as "test123" and password as "password"
      And User clicks on Login with google
      Then Error message pops up as "The password is wrong. Try again or click Forgot your password? to reset it."


    @InvalidLogin
    Scenario: Login with invalid Facebook credentials
      Given User navigates to Spotify "https://open.spotify.com/"
      And  User click on Log in button
      When User click on Continue with Facebook
      And User waits for cookies to be accepted
      And User enters username as "test123" and password as "password123"
      And User click on Log in
      Then Error an error message is displayed as "Sorry, something went wrong."






