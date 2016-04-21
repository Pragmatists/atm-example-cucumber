package pl.pragmatists.atm.cukes.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import pl.pragmatists.atm.app.Application;
import pl.pragmatists.atm.support.CukesSpringConfiguration;
import pl.pragmatists.atm.support.dsl.AccountDomainInterface;

//@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
//@SpringApplicationConfiguration(Application.class)
//@WebAppConfiguration
//@WebIntegrationTest
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
