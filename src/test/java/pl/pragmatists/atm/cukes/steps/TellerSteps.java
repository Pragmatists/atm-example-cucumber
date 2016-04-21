package pl.pragmatists.atm.cukes.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.pl.Kiedy;
import pl.pragmatists.atm.app.Application;
import pl.pragmatists.atm.support.CukesSpringConfiguration;
import pl.pragmatists.atm.support.dsl.TellerInterface;

//@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
//@SpringApplicationConfiguration(Application.class)
//@WebAppConfiguration
//@WebIntegrationTest
public class TellerSteps {

    @Autowired
    private TellerInterface tellerInterface;
    
    @Kiedy("^wypłacę (\\d+) zł$")
    public void wypłacę_zł(int kwota) throws Throwable {
        tellerInterface.iWithdraw(kwota);
    }



    
}
