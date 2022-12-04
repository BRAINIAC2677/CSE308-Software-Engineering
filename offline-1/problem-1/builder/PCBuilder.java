package builder;

import personalcomputer.PersonalComputer;
import component.ram.*;
import component.graphicscard.*;

public abstract class PCBuilder {
    protected PersonalComputer personal_computer;

    public PCBuilder() {
        personal_computer = new PersonalComputer();
    }

    public abstract void addProcessor();

    public void addCooler() {
    }

    public void addDVDDrive() {
    }

    public void addRAM(RAM ram) {
        personal_computer.addComponent(ram);
    }

    public void addGraphicsCard(GraphicsCard graphics_card) {
        personal_computer.addComponent(graphics_card);
    }

    public PersonalComputer getPersonalComputer() {
        return personal_computer;
    }

}