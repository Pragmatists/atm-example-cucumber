package pl.pragmatists.atm.support.dsl;

import pl.pragmatists.atm.domain.Teller;

public class TellerDomainInterface {
    private Teller teller;

    private AccountDomainInterface accountDomainInterface;

    public TellerDomainInterface(Teller teller, AccountDomainInterface accountDomainInterface) {
        this.teller = teller;
        this.accountDomainInterface = accountDomainInterface;
    }

    public void iWithdraw(int amount) {
        teller.authenticateAs(accountDomainInterface.getDefaultAccount());
        teller.withdraw(amount);
    }
}
