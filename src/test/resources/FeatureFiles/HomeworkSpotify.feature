Feature: Spotify login


  Scenario: Connect with apple on Spotify
    Given  user navigates to login Spotify webpage
    When user clicks on login with Apple
    And user enters appleId as "teststefania@gmail.com" and password as "teststefania"
    Then error message pop-up "ID-ul Apple sau parola incorect(a). Ati uitat parola?"

  Scenario: Connect  on Spotify
    Given  user navigates to login Spotify webpage
    When  user enters username as "teststefania@yahoo.com" and password as "teststefania"
    Then error message appears "Nume utilizator sau parolă incorectă."

  Scenario: Connect with gmail on Spotify
    Given  user navigates to login Spotify webpage
    When user clicks on login with Gmail
    And user enters gmail as "teststefania@gmail.com" and password as "teststefania"
    Then error message  "Parola este greșită. Încearcă din nou sau dă clic pe Ai uitat parola? pentru a o reseta."