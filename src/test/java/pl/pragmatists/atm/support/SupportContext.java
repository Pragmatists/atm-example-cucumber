package pl.pragmatists.atm.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pl.pragmatists.atm.domain.CashDispenser;
import pl.pragmatists.atm.domain.Display;
import pl.pragmatists.atm.domain.Teller;
import pl.pragmatists.atm.service.AccountRepository;
import pl.pragmatists.atm.service.CardReader;
import pl.pragmatists.atm.support.dsl.AccountDomainInterface;
import pl.pragmatists.atm.support.dsl.CashDispenserDomainInterface;
import pl.pragmatists.atm.support.dsl.DisplayDomainInterface;

@Configuration
@ComponentScan(basePackages = {"pl.pragmatists.atm.cukes"})
public class SupportContext {

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
    public DisplayDomainInterface displayDomainInterface(Display display) {
        return new DisplayDomainInterface(display);
    }

}
