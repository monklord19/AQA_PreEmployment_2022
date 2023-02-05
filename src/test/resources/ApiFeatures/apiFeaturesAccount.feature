Feature: Account API testing

  Scenario: POST request for new user
    Given User is on DemoQA Swagger
    When User send a post req for new user with username: "adelin" and password: "moldovan"
    Then the respone status code is 201
