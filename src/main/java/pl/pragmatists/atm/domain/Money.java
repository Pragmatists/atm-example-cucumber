package pl.pragmatists.atm.domain;

import static java.lang.String.format;

public class Money {
    private final int decimal;
    private final int factorial;

    public Money(int decimal, int factorial) {
        this.decimal = decimal;
        this.factorial = factorial;
    }

    public Money subtract(int toWithdraw) {
        return new Money(decimal - toWithdraw, factorial);
    }

    public Money add(int amount) {
        return new Money(decimal + amount, factorial);
    }

    public boolean hasAtLeast(int amount) {
        return decimal >= amount;
    }

    public int getDecimal() {
        return decimal;
    }

    public int getFactorial() {
        return factorial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (decimal != money.decimal) return false;
        return factorial == money.factorial;

    }

    @Override
    public int hashCode() {
        int result = decimal;
        result = 31 * result + factorial;
        return result;
    }

    @Override
    public String toString() {
        return format("%d,%d", decimal, factorial);
    }
}
