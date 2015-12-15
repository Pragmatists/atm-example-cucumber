package pl.pragmatists.atm.support.dsl;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import pl.pragmatists.atm.domain.CashDispenser;

public class AtmDomainInterface {

    private CashDispenser cashDispenser;

    public AtmDomainInterface(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    public void assertDispensed(int amount) {
        AssertionsForInterfaceTypes.assertThat(cashDispenser.getDispensed()).isEqualTo(amount);
    }
}
