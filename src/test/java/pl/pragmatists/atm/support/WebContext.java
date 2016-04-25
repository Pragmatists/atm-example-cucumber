package pl.pragmatists.atm.support;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pl.pragmatists.atm.domain.Teller;
import pl.pragmatists.atm.support.dsl.AccountDomainInterface;
import pl.pragmatists.atm.support.dsl.TellerDomainInterface;
import pl.pragmatists.atm.support.dsl.TellerInterface;
import pl.pragmatists.atm.support.dsl.TellerWebInterface;

@Configuration
public class WebContext {

    private boolean useWeb = false;
    
    public void useWeb() {
        useWeb = true;
    }
    
    public void disableWeb(){
        useWeb = false;
    }
    
    @Bean
    @Scope("cucumber-glue")
    public TellerInterface tellerInterface(Teller teller, AccountDomainInterface accountDomainInterface) {
        
        if(useWeb){
            System.setProperty("webdriver.chrome.driver", System.getProperty("chromedriver", "./src/test/resources/drivers/chrome/" + driver()));
            return new TellerWebInterface(new ChromeDriver());
        } else {
            return new TellerDomainInterface(teller, accountDomainInterface);    
        }
    }
    
    private String driver() {

        String os = System.getProperty("os.name");
     
        if(os.contains("Windows")){
            return "chromedriver-windows32.exe";
        }
        if(os.contains("Linux")){
            String arch = System.getProperty("os.arch");
            return "chromedriver-linux" + ("amd64".equals(arch) ? "64": "32");
        }
        if(os.contains("Mac")){
            return "chromedriver-mac32";
        }
        throw new IllegalStateException("Unknown operation system. Please provied custom Chome Selenium driver.");
    }
}
