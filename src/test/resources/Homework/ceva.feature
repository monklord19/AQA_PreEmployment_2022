Feature:Login attempt

  Background:
    Given I open the website https://www.saucedemo.com/

  @ValidLogin
  Scenario: Login with valid credentials
    When I enter the "<userName>" and "<password>"
      | userName      | password     |
      | standard_user | secret_sauce |
    Then I should be logged successfully
    And  I should see the corect picture and details for each product

  @LockedUser
  Scenario: Login with locked used
    When I enter the "<userName>" and "<password>"
      | userName        | password     |
      | locked_out_user | secret_sauce |
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Sorry, this user has been locked out." message

  @InvalidUsername
  Scenario: Try to login with invalid username and valid password
    When I enter the "<userName>" and "<password>"
      | userName     | password     |
      | invalid_user | secret_sauce |
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Username and password do not match any user in this service" message

  @InvalidPassword
  Scenario: Try to login with valid username and invalid password
    When I enter the "<userName>" and "<password>"
      | userName      | password        |
      | standard_user | invalidPassword |
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Username and password do not match any user in this service" message

  @LoginWithoutUsername
  Scenario: Try to login without username
    When I enter the "<userName>" and "<password>"
      | userName | password     |
      |          | secret_sauce |
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Username is required." message


  @LoginWithoutPassword
  Scenario: Try to login without password
    When I enter the "<userName>" and "<password>"
      | userName      | password |
      | standard_user |          |
    Then I shouldn't be able to login
    And I should see the "Epic sadface: Password is required." message

  @LoginWithGlitchUser
  Scenario: Try to login with glitch user
    When I enter the "<userName>" and "<password>"
      | userName                | password     |
      | performance_glitch_user | secret_sauce |
    Then I shouldn't be able to login without refreshing the page

  @LoginWithProblemUser
  Scenario: Try to login with problem user
    When I enter the "<userName>" and "<password>"
      | userName     | password     |
      | problem_user | secret_sauce |
    Then I should be logged successfully
    And I should see the dog picture on each product