package pl.pragmatists.atm.cukes.hooks;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.pragmatists.atm.app.Application;

@Configuration
@EnableAutoConfiguration
public class TestApplication extends Application {

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {

        return new JettyEmbeddedServletContainerFactory();
    }

    
}
