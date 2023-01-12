@Smoke
Feature: Homework 5

  @InvalidLogin
  Scenario Outline: Login with invalid credentials
    Given User open the login page of Spotify "https://open.spotify.com/"
    And User click on login spotify from homepage
    And User enter an invalid username as "<username>"
    And User enter an invalid password as "<password>"
    Then User click on spotify login button
    And An error message appears "Invalid username or password"

      Examples:
          | username                 | password       |
          | andreeaaionesa@icloud.com| dunare3456     |

@InvalidLogin
  Scenario Outline: Login with invalid credentials via google mail
    Given User open the Spotify webpage "https://open.spotify.com/"
    And User click on login with Gmail
    And User click on login with another account
    And User enter a valid gmail as "<gmail>"
    And User enter an invalid passwordgmail as "<passwordgmail>"
    Then An error message should appear

    Examples:
    |gmail                     | passwordgmail |
    |aionesacatalina@gmail.com | kjdhchbgfhj   |

  @InvalidLogin
  Scenario Outline: Login with invalid credentials via apple
  Given User open the login webpage of Spotify "https://open.spotify.com/"
  And User click on login with Apple
  And User enter a valid username as "<username>"
  And User press continue button
  And User enter an invalid apple password as "<password>"
  Then User press the continue button

  Examples:
    | username                   | password   |
    | andreeaaionesa@icloud.com  | vdhadshkadf|