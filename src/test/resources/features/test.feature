Feature:testLogin


  Background:
    Given You are on the login page from the https://www.saucedemo.com/

  Scenario:Successful login
    Given I enter <userName> and <password>
      | userName      | password     |
      | standard_user | secret_sauce |
    When  I click the login button
    Then  The product page is displayed


  Scenario Outline:Invalid username and password
    Given input <InvalidUsername> and <InvalidPassword>
    When  click on login button
    Then  display <ErrorMessage> "
    Examples:
      | InvalidUsername | InvalidPassword       | ErrorMessage                                                              |
      | Invalid         | InvalidButThePassword | Epic sadface: Username and password do not match any user in this service |

  Scenario : Empty password field
    Given input <ValidUsername>  and empty password field
      | ValidUsername |
      | standard_user |
    When click login button
    Then display <ErrorMessage>
      | ErrorMessage                       |
      | Epic sadface: Password is required |

  Scenario : Empty username field
    Given empty username and <validPassword>
      | validPassword |
      | secret_sauce  |
    When click login button
    Then Display <ErrorMessageUsernameIsRequired>
      | ErrorMessageUsernameIsRequired      |
      | Epic sadface : Username is required |

  Scenario:CLick login button with the empty fields
    Given Have the username and password fields empty
    When Click login button
    Then Display <ErrorMessageUsernameIsRequired>

git branhc  Scenario: Error Locked out user
    Given I enter <userName> and <password>
      | userName        | password     |
      | locked_out_user | secret_sauce |
    When  I click the login button
    Then This <error> should be displayed
      | error                                               |
      | Epic sadface: Sorry, this user has been locked out. |

  Scenario:Logout test
    Given I enter <userName> and <password>
      | userName      | password     |
      | standard_user | secret_sauce |
    And I click the login button
    When The product page is displayed
    And I click on the menu button
    And I clikc on logout link
    Then Login page should be displayed