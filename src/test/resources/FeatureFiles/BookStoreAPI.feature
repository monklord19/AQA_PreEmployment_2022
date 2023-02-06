Feature: API tests for Book Store

   Scenario: Create user
     Given User is on Demoqa Swagger website
     When User enters username and password for the post request
      Then User is created

   Scenario: Generate token
     Given User is on Demoqa Swagger website
     When User enters username and password to generate token
     Then Token is generated

   Scenario: Verify Authorization
      Given User is on Demoqa Swagger website
      When User enters username and password to verify authorization
      Then Authorization status is displayed

   Scenario: Get all books
      Given User is on Demoqa Swagger website
      When User sends GET request for all books
      Then Collection of books is displayed

   Scenario: Create books
      Given User is on Demoqa Swagger website
      When User enters userId and two isbn for the post request
      Then Created books are displayed

   Scenario: Get single book
      Given User is on Demoqa Swagger website
      When User sends GET request for single book
      Then Requested book is displayed

   Scenario: Update book
      Given User is on Demoqa Swagger website
      When User sends PUT request to update a book
      Then Book is updated

   Scenario: Delete single book
      Given User is on Demoqa Swagger website
      When User sends DELETE request to delete a book
      Then Book is deleted

   Scenario: Delete all books
      Given User is on Demoqa Swagger website
      When User sends DELETE request to delete all books
      Then All books are deleted






