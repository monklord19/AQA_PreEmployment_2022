Feature: Logout
  This feature deals with logout functionality

  @Logout
  Scenario: Logout successfully
    Given User is logged in "https://www.saucedemo.com/"
    When User navigates to side menu
    And User click on logout button
    Then User is redirected to login page

