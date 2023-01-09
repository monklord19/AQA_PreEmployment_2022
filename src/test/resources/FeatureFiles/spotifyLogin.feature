Feature: Spotify check wrong credentials

Scenario: Check if page exists
  Given Open spotify login page
  Then Spotify login page should be displayed

Scenario: Check if error message is displayed
  Given Open spotify login page
  When I enter username "fakeusername@fakemare.com"
  And I enter password "fakepass"
  And I press login button
  Then Error message should be displayed