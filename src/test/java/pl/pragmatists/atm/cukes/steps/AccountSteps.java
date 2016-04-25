package pl.pragmatists.atm.cukes.steps;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import pl.pragmatists.atm.support.dsl.AccountDomainInterface;

public class AccountSteps {

    @Autowired
    private AccountDomainInterface accountInterface;
    
    @Zakładając("^że mam konto na którym są środki (\\d+) zł$")
    public void że_mam_konto_na_którym_są_środki_zł(int kwota) throws Throwable {
        accountInterface.accountHasBeenCreditedWith(kwota);
    }

    @Wtedy("^stan konta powinien wynosić (\\d+) zł$")
    public void stan_konta_powinien_wynosić_zł(int stanKonta) throws Throwable {
        accountInterface.assertAccountBalance(stanKonta);
    }
    
}
