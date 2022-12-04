package builder;

import component.drive.*;
import component.processor.*;

public class TypeTwoPCBuilder extends PCBuilder {
    @Override
    public void addProcessor() {
        personal_computer.addComponent(new Corei7());
    }

    @Override
    public void addDVDDrive() {
        personal_computer.addComponent(new DVDDrive());
    }
}