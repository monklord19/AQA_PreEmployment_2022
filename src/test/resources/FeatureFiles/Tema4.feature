Feature: Tema 4

  Scenario: Login on spotify with e-mail address
    Given user enters e-mail address and invalid password
    When user clicks on login buttton
    Then the error message is displayed "Nume utilizator sau parolă incorectă."

  Scenario: Login on spotify with google account
    Given user enters google account
    When user clicks on next button
    Then the message is displayed "Nu te-am putut conecta"
