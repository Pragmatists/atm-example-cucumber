package pl.pragmatists.atm.support;

import pl.pragmatists.atm.domain.CashDispenser;

public class FakeCashDispenser implements CashDispenser {

    private int dispensed;

    @Override
    public int getDispensed() {
        return dispensed;
    }

    @Override
    public void dispense(int amount) {
        this.dispensed = amount;
    }

}
