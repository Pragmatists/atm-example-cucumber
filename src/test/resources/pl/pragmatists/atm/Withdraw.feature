#language: pl

Potrzeba biznesowa: : Użytkownik może wypłacić pieniądze z bankomatu
  Użytkownik może wypłacić pieniądze zdeponowane na swoim koncie w bankomacie.

  Scenariusz: : Użytkownik wypłaca pieniądze z bankomatu
    Zakładając że mam konto na którym są środki 200zł
    Kiedy wypłacę 130zł
    Wtedy powinno zostać wypłacone 130zł
    I stan konta powinien wynosić 70zł
