Feature: ApiTests

    Scenario: GET Single User status code
        Given User is on API address
        When User sends a get request for  user '2'
        Then  User receives status code 200


    Scenario: Test DELETE user status code
        Given User is on API address
        When user sends delete request for user number: '2'
        Then User receives status code 204


    Scenario: Test POST create new user status code
        Given User is on API address
        When The user makes a request to create an user
        Then The user is created


    Scenario: Test POST login successful status code
        Given User is on API address
        When user sends post login request with username and password
        Then The user is logged in

    Scenario: Test PUT update an user
        Given User is on API address
        When The user update the name and the job
        Then The user is updated
