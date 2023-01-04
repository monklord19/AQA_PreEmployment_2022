Feature: Login page

Scenario: Invalid login with numbers characters on the username
  Given On sauce website
  Given  I enter random numbers on the username
  And  I let password blank
  When  I press the login button
  Then  Login shouldn't work

Scenario: Valid login into the page
  Given On sauce website
  Given I enter the username "standard_user"
  And  I enter the password "secret_sauce"
  When I press the login button
  Then  I should be logged in



#  Scenario: Invalid login with numbers characters on the username
#  Given I enter the username "2312313"
#  And  I enter the password ""
#  When  I press the login button
#  Then  Login shouldn't work

