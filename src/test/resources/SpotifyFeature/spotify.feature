@Smoke
Feature: Homework 5

  @InvalidLogin
  Scenario Outline: Login with invalid credentials
    Given User open the login page of Spotify "https://open.spotify.com/"
    And User click on login spotify from homepage
    And User enter invalid spotify username as "<spotify_username>"
    And User enter invalid spotify password as "<password>"
    Then User click on spotify login button
    And An error message appears "Invalid username or password"

      Examples:
          | spotify_username                 | password       |
          | dfgjhkcvhgjkjhc                  | dunare3456     |

@InvalidLogin
  Scenario Outline: Login with invalid credentials via google mail
    Given User open the Spotify webpage "https://open.spotify.com/"
    And User open the connect page
    And User click on login with Gmail
    And User enter a valid gmail as "<gmail>"
    And User press the move on button
    And User enter an invalid google pass as "<pass>"
    Then An error message should appear

    Examples:
    |gmail                     | pass |
    |aionesacatalina@gmail.com | kjdhchbgfhj   |

  @InvalidLogin
  Scenario Outline: Login with invalid credentials via apple
  Given User open Spotify "https://open.spotify.com/"
  And User press the Login Spotify
  And User click on login with Apple
  And User enter a valid apple account as "<accountapple>"
  And User press continue button
  And User enter an invalid apple password as "<passapple>"
  Then User press the final continue button
  And An errorapple appears "Your Apple ID or password was incorrect. Forgotten your password?"

  Examples:
    | accountapple                   | passapple   |
    | andreeaaionesa@icloud.com  | vdhadshkadf|


  @InvalidLogin
  Scenario Outline: Login with invalid credentials via facebook
  Given User open Webpage Spotify "https://open.spotify.com/"
  And User press the button Login Spotify
  And User click on login with Facebook
  And User enter a valid facebook account as "<accountfacebook>"
  And User enter an invalid facebook password as "<passfacebook>"
  Then User press connect facebook
  And An error Facebook appears "The password that you've entered is incorrect. Forgotten password?"

  Examples:
    | accountfacebook                   | passfacebook   |
    | andreeaaionesa@yahoo.com          | jshjdfkdkn|