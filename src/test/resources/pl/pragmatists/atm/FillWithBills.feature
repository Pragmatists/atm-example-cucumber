#language: pl

  Potrzeba biznesowa: Banknoty są wypłacane z bankomatu

    Scenariusz: Bankomat wypłaca banknoty
      Mając bankomat wypełniony banknotami:
        | 100 | 5   |
        | 20  | 10  |
        | 10  | 20  |
      I że mam konto na którym są środki 300,00 zł
      Gdy wypłacę 250 zł
      Wtedy bankomat powinien mieć banknoty
        | 100 | 3   |
        | 20  | 8   |
        | 10  | 19  |