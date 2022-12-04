package component.cpu;

import component.Component;

public class CPU implements Component {
    @Override
    public String toString() {
        return "CPU";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}