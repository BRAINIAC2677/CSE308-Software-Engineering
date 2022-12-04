package component.cooler;

public class CPUCooler extends Cooler {
    @Override
    public String toString() {
        return "CPU Cooler";
    }

    @Override
    public double getPrice() {
        return 36000;
    }
}