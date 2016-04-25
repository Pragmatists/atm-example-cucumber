package pl.pragmatists.atm.cukes.hooks;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pl.pragmatists.atm.app.Application;
import pl.pragmatists.atm.support.SupportContext;
import pl.pragmatists.atm.support.TestContext;
import pl.pragmatists.atm.support.WebContext;

@Configuration
@EnableAutoConfiguration
@Import({WebContext.class, SupportContext.class, TestContext.class})
public class TestApplication extends Application {

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return new JettyEmbeddedServletContainerFactory();
    }
    
}
