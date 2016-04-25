package pl.pragmatists.atm.support.dsl;

import pl.pragmatists.atm.domain.Display;

import static org.mockito.Mockito.verify;

public class DisplayDomainInterface {
    
    private Display display;

    public DisplayDomainInterface(Display display) {
        this.display = display;
    }

    public void assertMessageShown(String expectedMessage) {
        verify(display).showMessage(expectedMessage);
    }
}
