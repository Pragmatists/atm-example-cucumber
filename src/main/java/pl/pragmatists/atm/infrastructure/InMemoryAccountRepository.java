package pl.pragmatists.atm.infrastructure;

import pl.pragmatists.atm.domain.Account;
import pl.pragmatists.atm.service.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {

    private Map<Long, Account> accounts = new HashMap<>();

    @Override
    public void clear() {
        accounts.clear();
    }

    @Override
    public Account find(long accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public Account create(long accountNumber) {
        Account account = new Account(accountNumber);
        accounts.put(accountNumber, account);
        return account;
    }
}
