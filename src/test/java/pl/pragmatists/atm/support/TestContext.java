package pl.pragmatists.atm.support;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import pl.pragmatists.atm.domain.Display;

@Configuration
public class TestContext {

    @Bean
    @Primary
    public Display createMockDisplay() {
        return Mockito.mock(Display.class);
    }
    
}
