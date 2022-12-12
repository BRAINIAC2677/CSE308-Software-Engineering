package car;

import color.*;
import country.*;
import engine.*;
import drivetrain.*;

public abstract class Car {
    protected Color color;
    protected Country manufacturing_country;
    protected Engine engine;
    protected DriveTrain drive_train;

    public abstract void buildCar();

    public Color getColor() {
        return color;
    }

    public Country getManufacturingCountry() {
        return manufacturing_country;
    }

    public Engine getEngine() {
        return engine;
    }

    public DriveTrain getDriveTrain() {
        return drive_train;
    }

    public void printCar() {
        String divider = "----------------------------------------";
        System.out.println(divider);
        System.out.println("Color: " + getColor());
        System.out.println("Manufacturing Country: " + getManufacturingCountry());
        System.out.println("Engine: " + getEngine());
        System.out.println("Drivetrain: " + getDriveTrain());
        System.out.println();
    }

}