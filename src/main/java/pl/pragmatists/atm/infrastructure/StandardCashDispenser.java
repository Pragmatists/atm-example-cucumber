package pl.pragmatists.atm.infrastructure;

import pl.pragmatists.atm.domain.CashDispenser;

public class StandardCashDispenser implements CashDispenser {

    private int amount;

    @Override
    public int getDispensed() {
        return amount;
    }

    @Override
    public void dispense(int amount) {
        this.amount = amount;
        System.out.println("Dispenced: " + amount);        
    }

}
