import java.io.Console;
import java.util.List;
import java.util.ArrayList;

import car.*;

class LocationAwareProductionSystem {
    String location;

    public LocationAwareProductionSystem(String location) {
        this.location = location;
    }

    public Car produce() {
        Car car = null;
        if (location.equalsIgnoreCase("USA")) {
            car = new USACar();
        } else if (location.equalsIgnoreCase("Europe")) {
            car = new EuropeanCar();
        } else if (location.equalsIgnoreCase("Asia")) {
            car = new AsianCar();
        }
        car.buildCar();
        return car;
    }
}

public class Main {
    public static void main(String[] args) {
        String location;
        List<String> locations = new ArrayList<String>();
        locations.add("USA");
        locations.add("Europe");
        locations.add("Asia");

        Console console = System.console();
        while (true) {
            location = console.readLine("Enter location: ");
            if (locations.contains(location)) {
                break;
            }
        }
        LocationAwareProductionSystem production_system = new LocationAwareProductionSystem(location);
        Car car = production_system.produce();
        car.printCar();
    }
}