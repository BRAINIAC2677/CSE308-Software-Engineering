package component.motherboard;

import component.Component;

public class Motherboard implements Component {
    @Override
    public String toString() {
        return "Motherboard";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}