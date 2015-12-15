package pl.pragmatists.atm.cukes.steps;

import cucumber.api.PendingException;
import cucumber.api.java.pl.Zakładając;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pragmatists.atm.support.CukesSpringConfiguration;

@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class AccountSteps {
    @Zakładając("^że mam konto na którym są środki (\\d+)zł$")
    public void że_mam_konto_na_którym_są_środki_zł(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
