Feature:Login attempt

  Background:
    Given I open the website

  @ValidLogin
  Scenario: Login with valid credentials
    When I enter the "standard_user" and "secret_sauce"
    Then I should be logged successfully
    And  I should see the corect picture and details for each product

  @LockedUser
  Scenario: Login with locked used
    When I enter the "locked_out_user" and "secret_sauce"
    Then I should not be logged successfully
    And I should see the "Epic sadface: Sorry, this user has been locked out." message

  @InvalidUsername
  Scenario: Try to login with invalid username and valid password
    When I enter the "invalid_user" and "secret_sauce"
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Username and password do not match any user in this service" message

  @InvalidPassword
  Scenario: Try to login with valid username and invalid password
    When I enter the "standard_user" and "invalidPassword"
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Username and password do not match any user in this service" message

  @LoginWithoutUsername
  Scenario: Try to login without username
    When I enter the "" and "secret_sauce"
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Username is required." message


  @LoginWithoutPassword
  Scenario: Try to login without password
    When I enter the "standard_user" and ""
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Password is required." message

  @LoginWithGlitchUser
  Scenario: Try to login with glitch user
    When I enter the "performance_glitch_user" and "secret_sauce"
    Then I should be able to login but with a longer waiting time

  @LoginWithProblemUser
  Scenario: Try to login with problem user
    When I enter the "problem_user" and "secret_sauce"
    Then I should be logged successfully
    And I should see the dog picture on each product

    @VerifyLogOut
    Scenario: Verify if logout works
      When I enter the "standard_user" and "secret_sauce"
      And I'm successfully login
      And From menu I press logout button
      Then I should be logged out successfully
