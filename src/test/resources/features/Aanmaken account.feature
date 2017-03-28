#language:nl

Functionaliteit: Account aanmaken op de webshop

  Scenario: gebruiker wil ik een account aan kunnen maken

    Gegeven: het scherm ‘account aanmaken’ zichtbaar is

    Als ik een accountgegevens invul voor "John" "tester", "24-08-1978" en "test@test.nl" met een standaard adres
    En het password met “test123”
    En als ik op de knop ‘aanmaken' klik

    Dan komen mijn gegevens in de database
    En kan ik inloggen

