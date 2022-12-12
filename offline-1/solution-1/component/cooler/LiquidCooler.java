package component.cooler;

public class LiquidCooler extends Cooler {
    @Override
    public String toString() {
        return "Liquid Cooler";
    }

    @Override
    public double getPrice() {
        return 17000;
    }
}