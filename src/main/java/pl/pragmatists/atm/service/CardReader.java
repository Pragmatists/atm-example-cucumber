package pl.pragmatists.atm.service;

import pl.pragmatists.atm.domain.Account;
import pl.pragmatists.atm.domain.Teller;

public class CardReader {
    private Teller teller;
    protected AccountRepository accountRepository;

    public CardReader(Teller teller, AccountRepository accountRepository) {
        this.teller = teller;
        this.accountRepository = accountRepository;
    }

    public void readCard(long cardNumber) {
        Account account = accountRepository.find(cardNumber);
        teller.authenticateAs(account);
    }
}
