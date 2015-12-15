package pl.pragmatists.atm.cukes.hooks;

import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pragmatists.atm.support.CukesSpringConfiguration;

@ContextConfiguration(classes = CukesSpringConfiguration.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class EnableWebHook {

    public static final String SELENIUM_PROFILE_NAME = "selenium";

    @Autowired
    private ConfigurableEnvironment env;

    @Before("@web")
    public void enableWeb() {
        env.setActiveProfiles(SELENIUM_PROFILE_NAME);
    }
}

