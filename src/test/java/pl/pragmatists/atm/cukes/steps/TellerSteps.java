package pl.pragmatists.atm.cukes.steps;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.pl.Kiedy;
import pl.pragmatists.atm.support.dsl.TellerInterface;

public class TellerSteps {

    @Autowired
    private TellerInterface tellerInterface;
    
    @Kiedy("^wypłacę (\\d+) zł$")
    public void wypłacę_zł(int kwota) throws Throwable {
        tellerInterface.iWithdraw(kwota);
    }
    
}
