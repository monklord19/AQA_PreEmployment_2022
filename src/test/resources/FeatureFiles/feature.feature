Scenario: Login using valid credentials
Given I am on the site login page
When I try to log in using "standard_user" as username and "secret_sauce" as password
And I click the "LOGIN" button
Then I should be logged in successfully

Scenario: Login using valid username and wrong password
Given I am on the site login page
When I try to log in using "standard_user" as username and "wrong_sauce" as password
And I click the "LOGIN" button
Then the "Epic sadface: Username and password do not match any user in this service" message should be visible

Scenario: Login using wrong username and valid password
Given I am on the site login page
When I try to log in using "not_standard_user" as username and "secret_sauce" as password
And I click the "LOGIN" button
Then the "Epic sadface: Username and password do not match any user in this service" message should be visible

Scenario: Login using valid username and empty password
Given I am on the site login page
When I try to log in using "standard_user" as username and " " as password
And I click the "LOGIN" button
Then the "Epic sadface: Password is required" message should be visible

Scenario: Login using empty username and valid password
Given I am on the site login page
When I try to log in using " " as username and "secret_sauce" as password
And I click the "LOGIN" button
Then the "Epic sadface: Username is required" message should be visible

Scenario: Login with no credentials
Given I am on the site login page
When I try to log in using " " as username and " " as password
And I click the "LOGIN" button
Then the "Epic sadface: Username is required" message should be visible

