package builder;

import component.cooler.*;
import component.processor.*;

public class GamingPCBuilder extends PCBuilder {
    @Override
    public void addProcessor() {
        personal_computer.addComponent(new Ryzen5700());
    }

    @Override
    public void addCooler() {
        personal_computer.addComponent(new CPUCooler());
    }
}