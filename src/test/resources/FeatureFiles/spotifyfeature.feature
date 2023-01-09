Feature:Log in with invalid credentials

  Scenario:Log in with invalid credentials
    Given Acces the test website for testing
    When Write invalid credentials and press login button
    And User click on loggin button
    Then Warning message appears