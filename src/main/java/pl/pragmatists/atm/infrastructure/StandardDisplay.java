package pl.pragmatists.atm.infrastructure;

import pl.pragmatists.atm.domain.Display;

public class StandardDisplay implements Display {

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

}
