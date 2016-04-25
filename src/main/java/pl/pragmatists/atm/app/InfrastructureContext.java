package pl.pragmatists.atm.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.pragmatists.atm.domain.CashDispenser;
import pl.pragmatists.atm.domain.Display;
import pl.pragmatists.atm.infrastructure.InMemoryAccountRepository;
import pl.pragmatists.atm.infrastructure.StandardCashDispenser;
import pl.pragmatists.atm.infrastructure.StandardDisplay;
import pl.pragmatists.atm.service.AccountRepository;

@Configuration
public class InfrastructureContext {

    @Bean
    public Display display(){
        return new StandardDisplay();
    }
    
    @Bean
    public CashDispenser cashDispenser(){
        return new StandardCashDispenser();
    }
    
    @Bean
    public AccountRepository accountRepository(){
        return new InMemoryAccountRepository();
    }
    
}
