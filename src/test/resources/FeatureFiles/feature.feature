@Smoke
Feature: Homework week 2 ~Tuesday~

  @ValidLogin
  Scenario Outline: Login with valid credentials
    Given User go to "https://www.saucedemo.com/"
    And User type a valid username as "<username>"
    And User enter a valid password as "<password>"
    When User press the login button
    Then The home page appears
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @InvalidLogin
  Scenario Outline: Login with invalid credentials
    Given User log in the Sauce site "https://www.saucedemo.com/"
    And User enter invalid username as "<username>"
    And User enter invalid password as "<password>"
    When User press the login button
    Then Error message is displayed "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username     | password     |
      | 1234         | 0987         |
      | problem_user | secret_santa |
      | PROBLEM_USER | SECRET_SAUCE |
      | *^$#         | *^%$#        |

  Scenario: User logged out from website
    Given User is logged in Sauce site
    When User click on hamburger button
    And User click on logout button
    Then User is back on Login page

  Scenario: Verify the cart functionality
    Given User is logged in Sauce site
    When User add an item pressing the cart button
    Then The item should appear in cart
    And  The cart page opens