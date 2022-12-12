package carfactory;

import color.*;
import engine.*;
import drivetrain.*;
import country.*;

public class ToyotaFactory implements CarFactory {
    @Override
    public Color createColor() {
        return new Red();
    }

    @Override
    public Engine createEngine() {
        return new HydrogenFuelEngine();
    }

    @Override
    public DriveTrain createDriveTrain() {
        return new RearWheelDriveTrain();
    }

    @Override
    public Country createManufacturingCountry() {
        return new Japan();
    }
}
