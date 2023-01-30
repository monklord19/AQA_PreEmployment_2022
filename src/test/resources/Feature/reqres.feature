Feature: API testing in reqres.in
  Background: Open the reqres.in https://reqres.in/

Scenario: Get the users
  Given User is connected to reqres in
  When The user makes a request to get all users
  Then The users should be displayed
  And The response status code should be 200

Scenario: Get a single user
  Given User is connected to reqres in
  When The user makes a request to get a single user
  Then The user should be displayed

Scenario: Search for an user that does not exist
  Given User is connected to reqres in
  When The user makes a request to get a user
  Then The user should not be displayed

Scenario: Get the list of resources
  Given User is connected to reqres in
  When The user makes a request to get the list of resources
  Then The list should be displayed

Scenario: Get the a single resource
  Given User is connected to reqres in
  When The user makes a request to get ta single resource
  Then The resource should be displayed

Scenario: Search for a resource that does not exist
  Given User is connected to reqres in
  When The user makes a request to get a resource
  Then The resource should not be displayed

Scenario: Create an user
  Given User is connected to reqres in
  When The user makes a request to create an user
  Then The user is created

Scenario: Login successfully
  Given User is on sign in page
  When The user enter valid credentials
  Then The user is logged in

Scenario: Update an user
  Given User is connected to reqres in
  When The user update the name and the job
  Then The user is updated

Scenario: Delete an user
  Given User is connected to reqres in
  When Delete one user
  Then The user is deleted





