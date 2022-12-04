package component.drive;

public class DVDDrive extends Drive {
    @Override
    public String toString() {
        return "DVD Drive";
    }

    @Override
    public double getPrice() {
        return 6000;
    }
}