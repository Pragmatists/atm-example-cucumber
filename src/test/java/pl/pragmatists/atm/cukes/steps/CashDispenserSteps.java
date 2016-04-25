package pl.pragmatists.atm.cukes.steps;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.pl.Wtedy;
import pl.pragmatists.atm.support.dsl.CashDispenserDomainInterface;

public class CashDispenserSteps {

    @Autowired
    private CashDispenserDomainInterface cashDispenser;
    
    @Wtedy("^powinno zostać wypłacone (\\d+) zł$")
    public void powinno_zostać_wypłacone_zł(int wyplaconaKwota) throws Throwable {
        cashDispenser.assertDispensed(wyplaconaKwota);
    }
    
}
