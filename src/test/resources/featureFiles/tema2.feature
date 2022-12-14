Feature: Testing login page

Scenario: Refresh the page
 Given  I enter the username
 When  I click on refresh button
 Then  Page should be refreshed

Scenario: Valid login into the page
 Given I enter the username
 And  I enter the password
 When I press the login button
 Then  I should be logged in

Scenario: Invalid login with whitespaces
 Given  I don't enter anything on username
 And  I don't enter anything on password
 When  I press the login button
 Then  An error pop-up should appear

Scenario: Invalid login with numbers characters on the username
 Given  I enter random numbers on the username
 And  I let password blank
 When  I press the login button
 Then  Login shouldn't work

Scenario: Invalid login with wrong credentials
 Given  I enter wrong credentials
 When  I press the login button
 Then  An error pop-up should appear that contain "wrong credentials"

Scenario: Expired password
 Given  I enter the username
 And  I enter the password
 When  I press the login button
 Then  An error pop-up should appear that contain "You're password has expired"

Scenario: Already logged in
 Given  I enter the username
 And  I enter the password
 When  I press the login button
 Then  An error appear with the message "You are already logged in"

Scenario: Caps lock on
 Given  I enter the username
 And  I start typing the password
 When  I check on the password
 Then  A message is displayed with "Caps lock is on"
