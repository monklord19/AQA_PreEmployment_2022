Feature: spotify login
  #  https://open.spotify.com/
#  Sa va logati cu google account si cu spotify account cu niste mailuri fictive si sa asertati erorile de pe pagina
  Background:
    Given You are on the spotify page


  Scenario: Invalid login with username and password
    Given Accept the cookies
    And Click login button
    When enter wrong username "invalidUsername" and invalid password "invalidPassword"
    And Click the conecteaza-te button
    Then Error is displayed "Nume utilizator sau parolă incorectă."


  Scenario: Invalid login with apple
    Given Accept the cookies
    And Click login button
    And Click on continue with apple
    When Enter wrong Apple id "user" and click continue
    And enter invalid password "password" and click continue
    Then the error is displayed "Acest ID Apple a fost blocat din motive de securitate"

