Feature: Login Page Test

  Background:
    Given User is on the login page

  Scenario Outline: Valid username and password
    When user enters '<username>' in username field
    And user enters '<password>' in password field
    And user clicks on login button
    Then current URL is: "https://www.saucedemo.com/inventory.html"
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario: Blank username and password
    When user enters '' in username field
    And user enters '' in password field
    And user clicks on login button
    Then error is displayed
    And message is: 'Epic sadface: Username is required'

  Scenario Outline: Locked username and password
    When user enters '<username>' in username field
    And user enters '<password>' in password field
    And user clicks on login button
    Then error is displayed
    And message is: 'Epic sadface: Sorry, this user has been locked out.'
    Examples:
      | username        | password     |
      | locked_out_user | secret_sauce |

  Scenario: Invalid username and password
    When user enters 'invalid_user' in username field
    And user enters '123456' in password field
    And user clicks on login button
    Then message is: 'Epic sadface: Username and password do not match any user in this service'


  Scenario Outline: Valid username and invalid password
    When user enters '<username>' in username field
    And user enters '123456' in password field
    And user clicks on login button
    Then message is: 'Epic sadface: Username and password do not match any user in this service'
    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |

  Scenario Outline: Invalid username and valid password
    When user enters 'invalid_user' in username field
    And user enters '<password>' in password field
    And user clicks on login button
    Then message is: 'Epic sadface: Username and password do not match any user in this service'
    Examples:
      | password     |
      | secret_sauce |

  Scenario Outline: Valid username and blank password
    When user enters '<username>' in username field
    And user enters '' in password field
    And user clicks on login button
    Then message is: 'Epic sadface: Password is required'
    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |

  Scenario Outline: Blank username and valid password
    When user enters '' in username field
    And user enters '<password>' in password field
    And user clicks on login button
    Then message is: 'Epic sadface: Username is required'
    Examples:
      | password |
      | secret_sauce |

  Scenario: Add product to cart
    Given user enters 'standard_user' in username field
    And user enters 'secret_sauce' in password field
    And user clicks on login button
    When add product to cart: 'Sauce Labs Onesie'
    And check if the product is added

  Scenario: Add product to cart
    Given user enters 'standard_user' in username field
    And user enters 'secret_sauce' in password field
    And user clicks on login button
    When add product to cart: 'Sauce Labs Onesie'
    And check if the product is added

  Scenario: Open burger meniu
    Given user enters 'standard_user' in username field
    And user enters 'secret_sauce' in password field
    And user clicks on login button
    When user clicks on burger meniu button
    And check if the meniu is opened