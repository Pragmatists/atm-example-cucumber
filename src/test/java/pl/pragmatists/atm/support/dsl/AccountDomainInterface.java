package pl.pragmatists.atm.support.dsl;

import pl.pragmatists.atm.domain.Account;
import pl.pragmatists.atm.domain.Teller;
import pl.pragmatists.atm.service.AccountRepository;
import pl.pragmatists.atm.service.CardReader;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDomainInterface {

    private static final int DEFAULT_ACCOUNT_NUMBER = 1111;

    private AccountRepository accountRepository;

    private CardReader cardReader;

    private Teller teller;

    public AccountDomainInterface(AccountRepository accountRepository, CardReader cardReader, Teller teller) {
        this.accountRepository = accountRepository;
        this.cardReader = cardReader;
        this.teller = teller;
    }

    public void accountHasBeenCreditedWith(int amount) {
        Account account = accountRepository.create(DEFAULT_ACCOUNT_NUMBER);
        account.credit(amount);
        assertAccountBalance(amount);
    }

    public void assertAccountBalance(int balance) {
        Account account = accountRepository.find(DEFAULT_ACCOUNT_NUMBER);
        assertThat(account.getBalance()).isEqualTo(balance);
    }

    public void cardUsed(int cardNumber) {
        cardReader.readCard(cardNumber);
    }

    public Account getDefaultAccount() {
        return accountRepository.find(DEFAULT_ACCOUNT_NUMBER);
    }

    public void registerCardWithAmount(long cardNumber, int ammount) {
        Account account = accountRepository.create(cardNumber);
        account.credit(ammount);
    }

    public void withdrawWithCard(long cardNumber, int ammount) {
        cardReader.readCard(cardNumber);
        teller.withdraw(ammount);
    }
}
