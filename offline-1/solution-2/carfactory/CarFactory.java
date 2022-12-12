package carfactory;

import color.Color;
import engine.Engine;
import drivetrain.DriveTrain;
import country.Country;

public interface CarFactory {

    public Color createColor();

    public Engine createEngine();

    public DriveTrain createDriveTrain();

    public Country createManufacturingCountry();
}