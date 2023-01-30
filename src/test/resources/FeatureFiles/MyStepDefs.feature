Feature: Homework

  Scenario: Valid username and password standard_user
    Given On sauce website
    When User enters valid credential "standard_user" and "secret_sauce"
    Then User should be logged with success "true"

  Scenario: Valid username and password locked_out_user
    Given On sauce website
    When User enters valid credential "locked_out_user" and "secret_sauce"
    Then User should be logged with success "false"

  Scenario: Valid username and password problem_user
    Given On sauce website
    When User enters valid credential "problem_user" and "secret_sauce"
    Then User should be logged with success "true"

  Scenario: Valid username and password performance_glitch_user
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and "secret_sauce"
    Then User should be logged with success "true"

  Scenario: Valid username and password empty_password
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and ""
    Then User should be logged with success "false"

  Scenario: Valid username and password wrong_password
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and "wrong_password"
    Then User should be logged with success "false"

  Scenario: Valid username and password empty_username
    Given On sauce website
    When User enters valid credential "" and "secret_sauce"
    Then User should be logged with success "false"

  Scenario: Valid username and password and long duration login
    Given On sauce website
    When User enters valid credential "performance_glitch_user" and "secret_sauce"
    Then User should be logged with success "true"
    And Loading takes more then or equal to 5 seconds

  Scenario: Valid username and password and short duration login
    Given On sauce website
    When User enters valid credential "standard_user" and "secret_sauce"
    Then User should be logged with success "true"
    And Loading takes less then or equal to 2 seconds

  Scenario: Add product to cart
    Given On sauce website
    When User enters valid credential "problem_user" and "secret_sauce"
    And  User adds all products
    Then User goes to cart and has all products

  Scenario: Test Impressive Radio Button on DemoQa
    Given On demo website
    When User selects impressive radio button
    Then Check label is displayed correctly

  Scenario: Log in in Spotify website
    Given On spotify website
    When User enters credentials "email-test@gmail.com" and "password-test"
    Then User need to be logged in with success "false"

  Scenario: Log in Spotify website via google
    Given On spotify website
    When User goes to login with google
    And User enter valid google an email "google-test@gmail.com"
    Then User should allowed to enter password "false"


  Scenario: Log in Spotify website via apple
    Given On spotify website
    When User goes to login with apple
    And User enter apple id "9999@yahoo.ro"
    And User enter apple password "bbbb"
    Then User should be logged in with apple account "false"

  Scenario: Log in Spotify website via facebook
    Given On spotify website
    When User goes to login with facebook
    And Allow cookies
    And User enter facebook credentials "facebook-test@gmail.com" and "facebook-password-test"
    Then User should be logged in with facebook account "false"
    And Refresh page to try another password
    And Enter another facebook password "facebook-second-password-test"
    Then User should be logged in with facebook account "false"

  Scenario: List users
    Given On API address
    When Send a get request for page 2
    Then Receive status code 200 and the response time

  Scenario: Single user found
    Given On API address
    When Sends a get request for the second user
    And Check number of properties in the 'data' object
    And Check number of properties in the 'support' object
    Then Receive status code 200 and the response time

  Scenario: Single user not found
    Given On API address
    When Send a get request for the no. 23 user
    Then Receive status code 404 and the response time

  Scenario: List <Resource>
    Given On API address
    When Send a get request for unknown page
    And Check number of values
    Then Receive status code 200 and the response time

  Scenario: Single <Resource>
    Given On API address
    When Send a get request for unknown page for id 2
    And Check number of id properties
    Then Receive status code 200 and the response time

  Scenario: Single <Resource> not found
    Given On API address
    When Send a get request for unknown page for id 23
    And Check data
    Then Receive status code 404 and the response time

  Scenario: Create properties
    Given On API address
    When Send a post request for name and job
    And Response body should contains name, job, id and createdAt
    Then Receive status code 201 and the response time

  Scenario: Update properties with put method
    Given On API address
    When Send a put request for name and job
    And Response body should contains name, job and createdAt
    Then Receive status code 200 and the response time

  Scenario: Update properties with patch method
    Given On API address
    When Send a patch request for name and job
    And Response body should contains name, job and createdAt
    Then Receive status code 200 and the response time

  Scenario: Delete properties with delete method
    Given On API address
    When Send a delete request to an API
    Then Receive status code 204 and the response time

  Scenario: Register successful
    Given On API address
    When Send register request to an API
    And Check body if contains id and token
    Then Receive status code 200 and the response time

  Scenario: Register unsuccessful
    Given On API address
    When Send a register request without password to an API
    Then Receive status code 400 and the response time

  Scenario: Login successful
    Given On API address
    When Send a login request to an API
    Then Receive status code 200 and the response time

  Scenario: Login unsuccessful
    Given On API address
    When Send a login request without password to an API
    Then Receive status code 400 and the response time

  Scenario: Delayed response
    Given On API address
    When Send a get request to an delayed API
    Then Receive status code 200 and the delayed response time
    








