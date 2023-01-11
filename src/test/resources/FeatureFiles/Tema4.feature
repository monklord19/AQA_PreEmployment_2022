Feature: Tema 4

  Scenario: Login on spotify with e-mail address
    Given user enters e-mail address and invalid password
    When user clicks on login button
    Then the error message is displayed "Nume utilizator sau parolă incorectă."

  Scenario: Login on spotify with google account
    Given user enters google account
    When user clicks on next button
    Then the message is displayed "Nu te-am putut conecta"

  Scenario: Login on spotify with facebook account
    Given user enters invalid facebook account
    When user clicks on facebook login button
    Then message is displayed "Parola pe care ai introdus-o este incorectă. Ai uitat parola?"

  Scenario: Login on spotify with apple account
    Given user enters invalid id apple and invalid password
    When user clicks on apple next button
    Then the message displayed is that the user is blocked
