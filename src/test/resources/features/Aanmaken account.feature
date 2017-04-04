#language:nl

Functionaliteit: Account aanmaken op de webshop

    @REGRESSIETEST
  Scenario: gebruiker wil ik een account aan kunnen maken

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

    Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "test2@test.nl" met een standaard adres
    En het password met "test123"
    En als ik op de knop ‘aanmaken' klik
       En test


    Dan komen mijn gegevens in de database
    En kan ik inloggen

