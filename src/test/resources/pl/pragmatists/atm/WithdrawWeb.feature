#language: pl
@web
Potrzeba biznesowa: : Użytkownik może wypłacić pieniądze z bankomatu
  Użytkownik może wypłacić pieniądze zdeponowane na swoim koncie w bankomacie.

  Szablon scenariusza: Użytkownik wypłaca <wypłacana_kwota> bankomatu przy saldzie początkowym <stan_początkowy>
    Zakładając że mam konto na którym są środki <stan_początkowy> zł
    Kiedy wypłacę <wypłacana_kwota> zł
    Wtedy powinno zostać wypłacone <otrzymane_pieniądze> zł
    I stan konta powinien wynosić <saldo_po_wypłacie> zł

    Przykłady:
    | stan_początkowy    | wypłacana_kwota | saldo_po_wypłacie | otrzymane_pieniądze |
    | 206,72             | 100             | 106,72            | 100                 |