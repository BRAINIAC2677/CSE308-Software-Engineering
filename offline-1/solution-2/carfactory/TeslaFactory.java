package carfactory;

import color.*;
import engine.*;
import drivetrain.*;
import country.*;

public class TeslaFactory implements CarFactory {
    @Override
    public Color createColor() {
        return new White();
    }

    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }

    @Override
    public DriveTrain createDriveTrain() {
        return new AllWheelDriveTrain();
    }

    @Override
    public Country createManufacturingCountry() {
        return new USA();
    }
}