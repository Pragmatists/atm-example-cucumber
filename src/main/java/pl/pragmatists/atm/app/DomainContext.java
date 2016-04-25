package pl.pragmatists.atm.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.pragmatists.atm.domain.AutomatedTeller;
import pl.pragmatists.atm.domain.CashDispenser;
import pl.pragmatists.atm.domain.Display;
import pl.pragmatists.atm.domain.Teller;
import pl.pragmatists.atm.service.AccountRepository;
import pl.pragmatists.atm.service.CardReader;

@Configuration
public class DomainContext {

    @Bean
    public Teller createTeller(CashDispenser cashDispenser, Display display) {
        return new AutomatedTeller(cashDispenser, display);
    }

    @Bean
    public CardReader cardReader(Teller teller, AccountRepository accountRepository) {
        return new CardReader(teller, accountRepository);
    }
      
}
