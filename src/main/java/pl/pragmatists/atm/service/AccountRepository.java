package pl.pragmatists.atm.service;

import pl.pragmatists.atm.domain.Account;

public interface AccountRepository {
    void clear();

    Account find(long accountNumber);

    Account create(long accountNumber);
}
