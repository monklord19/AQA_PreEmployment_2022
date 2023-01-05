@Smoke
Feature: Login functionality
  Background:I open the login page on saucedemo.com

    @ValidLogin
    #1
    Scenario: Login with valid credentials
      Given User opens https://www.saucedemo.com/
      When User enters username as standard_user and password as secret_sauce
      And User hit the login button
      Then Products page opens

  Scenario Outline: Login with valid credentials
    Given User opens https://www.saucedemo.com/
    When User enters "<username>" as standard_user and "<password>" as secret_sauce
    And User hit the login button
    Then Products page opens

    Examples:

      |   username        |     password         |
      |   standard_user   |    secret_sauce      |

    #2
  Scenario: Products added successfully in cart
     Given User is logged in with username and password
     When User clicks on add to card button
     Then Product is added to cart

    #3
    @InvalidLogin
  Scenario: Login with invalid credentials
    Given Invalid username as standard_user9 and password as secret_sauce
    When User click on login
    Then Error message is displayed "Username and password do not match any user in this service"

      Scenario Outline: Login with invalid credentials
        Given Invalid "<username>" as standard_user9 and "<password>" as secret_sauce
        When User click on login
        Then Error message is displayed "Username and password do not match any user in this service"
        Examples:
        |   username        |    password       |
        |   standard_user9  |    secret_sauce   |

    #4
  Scenario: Login with username blank and password as secret_sauce
    Given User have password field in and username blank
    When User clicks on login button
    Then User receive the following error message: "Epic sadface: Username is required"

  Scenario Outline: Login with username blank and password as secret_sauce
    Given User have "<password>" field in and "<username>" blank
    When User click on login button
    Then User receive the following "<error message>" : "Epic sadface: Username is required"

    Examples: |username |password      |error message                       |
    |         |secret_sauce  |Epic sadface: Username is required  |

    #5
  Scenario: Login with valid username and blank password
    Given Valid username as standard_user and blank password
    When User clicks on login button
    Then Error message is displayed "Password is required"

    #6

    Scenario: Login with incorrect credentials
      Given Valid username as locked_out_user and password as secret_sauce
      When User clicks on login button
      Then Error message pops up "Epic sadface: Sorry, this user has been locked out."

      Scenario Outline: Login with incorrect credentials
        Given Valid "<username>" as locked_out_user and "<password>" as secret_sauce
        When User clicks on login button
        Then Error message pops up "Epic sadface: Sorry, this user has been locked out."
        Examples:
        |     username             |    password        |
        |   locked_out_user        |  secret_sauce      |

     #7
      Scenario: Invalid login with numeric characters in username field
          Given User types some numeric characters in username field
          And Password is left in whitespaces
          When User clicks on login button
          Then Login shouldn't work
          And User should receive an error message

          Scenario Outline: Invalid login with numerical characters on username field
            Given User types some numerical characters on "<username>" field
            And "<Password>" is left in whitespaces
            When User click on login button
            Then Login shouldn't work
            And User should receive an "<error message>"
            Examples:
            |username     | Password   |error message     |
            |314143123    |            | Unable to login  |
            |424242       |            | Unable to login  |

    #8
            Scenario: Invalid login when both username and password are left in whitespaces
              Given Username and password left in whitespace
              When  User click on login button
              Then User shouldn't be authenticated
              And User should receive an error message

              Scenario Outline: Invalid login when both username and password are left in whitespaces
                Given "<Username>" and "<password>" left in whitespaces
                When User click on login button
                Then User shouldn't be authenticated
                And User should receive an "<error message>" such as "<Autentification faild>"

                Examples:
                |Username |password    |error message          |
                |         |            |Autentification faild  |

    #9
    @LoginRefresh
                Scenario: Refresh the login page
                  Given User is refreshing the login page with both username and password credentials field in
                  When User is refreshing the login page
                  Then The page should refresh
                  And The page should comeback at login page
                  And The page should remove older credential from username and password field
                  And The fields on the login page should be in whitespaces

                  Scenario Outline: Refresh the login page
                    Given User is refreshing the login page with both "<username>" and "<password>" credentials field in
                    When User is refreshing the login page with valid credentials
                     Examples:   |username      |password      |
                                 |standard_user |secret_sauce  |
                                 |problem_user  |secret_sauce  |
                    When User is refreshing the login page with invalid credentals
                     Examples:    |username       |password     |
                                 |2231221        | 4rf432      |
                                 |test21d        | 4d21rc!!$   |

                    Then The page should refresh
                    And The page should comeback at login page
                    And The page should remove older credential from username and password field
                    And The fields on the login page should be in whitespaces

    #10
  @InvalidAddToCartUser
  Scenario: Products added to cart successfully
    Given User standard_user is logged in
    When standard_user is adding some products to cart
    And standard_user is receiving a successful message that his product was added to cart
    And standard_user is logged out
    And problem_user is logged in
    And problem_user is adding a product to cart
    Then Products from standard_user remains in problem_user cart
    And problem_user shouldn't have any product in cart












