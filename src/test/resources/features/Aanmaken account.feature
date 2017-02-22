#language:nl

  Functionaliteit: Account aanmaken op de webshop

    Scenario: gebruiker wil ik een account aan kunnen maken

      Gegeven: het scherm ‘account aanmaken’ zichtbaar is

      Als ik het account in vul met “John”
        En het password met “test123”
        En als ik op de knop ‘aanmaken' klik

      Dan komen mijn gegevens in de database
        En kan ik inloggen

