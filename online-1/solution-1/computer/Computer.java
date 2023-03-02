package computer;

import shape.*;

public abstract class Computer {
    protected String cpu;
    protected String mmu;
    protected int resolutionX;
    protected int resolutionY;

    public Computer() {
        this.cpu = "mips";
        this.mmu = "ssd";
    }

    public abstract Shape createShape(String shapeType, double... args);

    public boolean isShapeFit() {
        Shape shape = createShape("circle", 10);
        return shape.area() < resolutionX * resolutionY;
    }
}