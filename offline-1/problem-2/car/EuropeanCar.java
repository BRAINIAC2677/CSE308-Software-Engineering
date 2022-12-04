package car;

import carfactory.*;

public class EuropeanCar extends Car {
    private CarFactory car_factory;

    public EuropeanCar() {
        this.car_factory = new BMWFactory();
    }

    public void buildCar() {
        this.color = car_factory.createColor();
        this.manufacturing_country = car_factory.createManufacturingCountry();
        this.engine = car_factory.createEngine();
        this.drive_train = car_factory.createDriveTrain();
    }
}