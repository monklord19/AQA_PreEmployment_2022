@Smoke
Feature: Homework 5

  @InvalidLogin
  Scenario Outline: Login with invalid credentials
    Given User open the login page of Spotify "https://accounts.spotify.com/ro-RO/login?continue=https%3A%2F%2Fopen.spotify.com%2F"
    And User enter an invalid username as "<username>"
    And User enter an invalid password as "<password>"
    Then User click on spotify login button
    And An error message appears "Nume utilizator sau parolă incorectă."

    Examples:
      | username          | password   |
      | alina@net.com     | maldive675 |
      | vanessa0lw@min.ro | bali71p    |

  @InvalidLogin
  Scenario Outline: Login with invalid credentials via google mail
    Given User open the login page of Spotify
    And User click on login with Gmail
    And The Gmail login page appears
    And User enter invalid credentials
    Then An error message should appear

    Examples:
      | username      | password  |
      | maria@et.com  | tunisia75 |
      | radulw@min.ro | nnxgswp   |