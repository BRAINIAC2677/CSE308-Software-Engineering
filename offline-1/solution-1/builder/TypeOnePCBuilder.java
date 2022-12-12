package builder;

import component.cooler.*;
import component.processor.*;

public class TypeOnePCBuilder extends PCBuilder {
    @Override
    public void addProcessor() {
        personal_computer.addComponent(new Corei5());
    }

    @Override
    public void addCooler() {
        personal_computer.addComponent(new LiquidCooler());
    }
}