package builder;

import component.processor.*;

public class TypeThreePCBuilder extends PCBuilder {
    @Override
    public void addProcessor() {
        personal_computer.addComponent(new Corei9());
    }
}