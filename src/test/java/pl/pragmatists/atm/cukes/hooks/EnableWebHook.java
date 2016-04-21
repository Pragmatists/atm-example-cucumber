package pl.pragmatists.atm.cukes.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.Before;
import pl.pragmatists.atm.support.CukesSpringConfiguration;

@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
@SpringApplicationConfiguration(TestApplication.class)
//@WebAppConfiguration
@WebIntegrationTest
public class EnableWebHook {

    public static final String SELENIUM_PROFILE_NAME = "selenium";

    @Autowired
    private ConfigurableEnvironment env;

    @Before("@web")
    public void enableWeb() {
        env.setActiveProfiles(SELENIUM_PROFILE_NAME);
    }
    
}

