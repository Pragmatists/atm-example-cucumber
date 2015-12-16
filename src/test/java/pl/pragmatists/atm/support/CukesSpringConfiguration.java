package pl.pragmatists.atm.support;

import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.ConfigurableEnvironment;
import pl.pragmatists.atm.domain.AutomatedTeller;
import pl.pragmatists.atm.domain.CashDispenser;
import pl.pragmatists.atm.domain.Display;
import pl.pragmatists.atm.domain.Teller;
import pl.pragmatists.atm.service.AccountRepository;
import pl.pragmatists.atm.service.CardReader;
import pl.pragmatists.atm.support.dsl.AccountDomainInterface;
import pl.pragmatists.atm.support.dsl.CashDispenserDomainInterface;
import pl.pragmatists.atm.support.dsl.DisplayDomainInterface;
import pl.pragmatists.atm.support.dsl.TellerDomainInterface;
import pl.pragmatists.atm.support.dsl.TellerInterface;
import pl.pragmatists.atm.support.dsl.TellerWebInterface;

import static java.util.Arrays.asList;
import static pl.pragmatists.atm.cukes.hooks.EnableWebHook.SELENIUM_PROFILE_NAME;

@Configuration
@ComponentScan(basePackages = {"pl.pragmatists.atm.cukes"})
public class CukesSpringConfiguration {

    @Autowired
    private ConfigurableEnvironment env;

    @Bean
    @Scope("cucumber-glue")
    public Display createDisplay() {
        return Mockito.mock(Display.class);
    }

    @Bean
    @Scope("cucumber-glue")
    public CashDispenser cashDispenser() {
        return new FakeCashDispenser();
    }

    @Bean
    @Scope("cucumber-glue")
    public Teller createTeller(CashDispenser cashDispenser, Display display) {
        return new AutomatedTeller(cashDispenser, display);
    }

    @Bean
    @Scope("cucumber-glue")
    public AccountRepository accountRepository() {
        return new InMemoryAccountRepository();
    }

    @Bean
    @Scope("cucumber-glue")
    public CardReader cardReader(Teller teller, AccountRepository accountRepository) {
        return new CardReader(teller, accountRepository);
    }

    @Bean
    @Scope("cucumber-glue")
    public AccountDomainInterface accountDomainInterface(AccountRepository accountRepository, CardReader cardReader, Teller teller) {
        return new AccountDomainInterface(accountRepository, cardReader, teller);
    }

    @Bean
    @Scope("cucumber-glue")
    public CashDispenserDomainInterface atmDomainInterface(CashDispenser cashDispenser) {
        return new CashDispenserDomainInterface(cashDispenser);
    }

    @Bean
    @Scope("cucumber-glue")
    public Display display() {
        return Mockito.mock(Display.class);
    }

    @Bean
    @Scope("cucumber-glue")
    public DisplayDomainInterface displayDomainInterface(Display display) {
        return new DisplayDomainInterface(display);
    }

    @Bean
    @Scope("cucumber-glue")
    public TellerInterface tellerInterface(Teller teller, AccountDomainInterface accountDomainInterface, WebDriver driver) {
        if (asList(env.getActiveProfiles()).contains(SELENIUM_PROFILE_NAME)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("chromedriver", "missing"));
            return new TellerWebInterface(driver);
        } else {
            return new TellerDomainInterface(teller, accountDomainInterface);
        }
    }

    @Bean
    public WebDriver driver() {
        return new ChromeDriver();
    }
}
