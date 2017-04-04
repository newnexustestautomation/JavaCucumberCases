#language:nl

Functionaliteit: Account aanmaken op de webshop

  @REGRESSIETEST
  Scenario: gebruiker wil ik een account aan kunnen maken

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

<<<<<<< HEAD
    Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "test@test.nl" met een standaard adres
      En het password met "test125"
      En als ik op de knop ‘aanmaken' klik
      En controleer foutmelding "e-mail address already exists"
=======
    Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "test2@test.nl" met een standaard adres
    En het password met "test123"
    En als ik op de knop ‘aanmaken' klik
       En test

>>>>>>> eb893ce66b9f6ac837ced3542d4e4c12a814e8b4

    Dan komen mijn gegevens in de database
      En kan ik inloggen




  Scenario: controleer melding bij leeglaten van veld

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

    Als ik een accountgegevens invul voor "John" "tester", "" en "test@test.nl" met een standaard adres
      En het password met "test125"
      En als ik op de knop ‘aanmaken' klik
      En controleer foutmelding "date of birth must be in this format" bij leeglaten van veld


