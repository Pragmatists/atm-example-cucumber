package pl.pragmatists.atm.cukes.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.pl.Wtedy;
import pl.pragmatists.atm.app.Application;
import pl.pragmatists.atm.support.CukesSpringConfiguration;
import pl.pragmatists.atm.support.dsl.CashDispenserDomainInterface;

//@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
//@SpringApplicationConfiguration(Application.class)
//@WebAppConfiguration
//@WebIntegrationTest
public class CashDispenserSteps {

    @Autowired
    private CashDispenserDomainInterface cashDispenser;
    
    @Wtedy("^powinno zostać wypłacone (\\d+) zł$")
    public void powinno_zostać_wypłacone_zł(int wyplaconaKwota) throws Throwable {
        cashDispenser.assertDispensed(wyplaconaKwota);
    }
    
}
