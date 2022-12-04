package car;

import carfactory.*;

public class USACar extends Car {
    private CarFactory car_factory;

    public USACar() {
        this.car_factory = new TeslaFactory();
    }

    public void buildCar() {
        this.color = car_factory.createColor();
        this.manufacturing_country = car_factory.createManufacturingCountry();
        this.engine = car_factory.createEngine();
        this.drive_train = car_factory.createDriveTrain();
    }
}