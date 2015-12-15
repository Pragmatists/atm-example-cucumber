#language: pl

Potrzeba biznesowa: : Użytkownik może wypłacić pieniądze z bankomatu
  Użytkownik może wypłacić pieniądze zdeponowane na swoim koncie w bankomacie.

  Scenariusz: : Użytkownik wypłaca pieniądze z bankomatu
    Zakładając że mam konto na którym są środki 200 zł
    Kiedy wypłacę 130 zł
    Wtedy powinno zostać wypłacone 130 zł
    I stan konta powinien wynosić 70 zł
