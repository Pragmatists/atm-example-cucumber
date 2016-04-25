package pl.pragmatists.atm.cukes.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pl.pragmatists.atm.support.WebContext;


@ContextConfiguration(classes=TestApplication.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest
public class EnableWebHook {

    @Autowired
    private WebContext context;
    
    @Before("~@web")
    public void beforeAny(){
        context.disableWeb();
    }
    
    @Before("@web")
    public void beforeWeb(){
        context.useWeb();
    }

    @After("@web")
    public void afterWeb(){
        context.disableWeb();
    }

}
