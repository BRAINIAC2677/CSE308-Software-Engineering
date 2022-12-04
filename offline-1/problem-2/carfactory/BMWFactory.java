package carfactory;

import color.*;
import engine.*;
import drivetrain.*;
import country.*;

public class BMWFactory implements CarFactory {
    @Override
    public Color createColor() {
        return new Black();
    }

    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }

    @Override
    public DriveTrain createDriveTrain() {
        return new RearWheelDriveTrain();
    }

    @Override
    public Country createManufacturingCountry() {
        return new Germany();
    }
}