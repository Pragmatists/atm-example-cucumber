package pl.pragmatists.atm.support.dsl;

import static java.lang.String.valueOf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TellerWebInterface implements TellerInterface {
    private WebDriver driver;

    public TellerWebInterface(WebDriver driver) {

        this.driver = driver;
    }

    @Override
    public void iWithdraw(int amount) {
        driver.get("http://localhost:8080/atm/main");
        driver.findElement(By.id("amount")).sendKeys(valueOf(amount));
        driver.findElement(By.id("withdraw")).click();
    }
}
