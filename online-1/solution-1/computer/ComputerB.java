package computer;

import shape.*;

public class ComputerB extends Computer {
    public ComputerB() {
        super();
        resolutionX = 350;
        resolutionY = 250;
    }

    public Shape createShape(String shapeType, double... args) {
        if (shapeType == "circle") {
            return new Circle(args[0]);
        } else if (shapeType == "rectangle") {
            return new Rectangle(args[0], args[1]);
        } else if (shapeType == "square") {
            return new Square(args[0]);
        } else {
            return null;
        }
    }
}