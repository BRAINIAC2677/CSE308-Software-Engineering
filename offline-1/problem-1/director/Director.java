package director;

import builder.*;

public class Director {
    private PCBuilder pc_builder;

    public PCBuilder construct(PCBuilder pc_builder) {
        this.pc_builder = pc_builder;
        this.pc_builder.addProcessor();
        this.pc_builder.addCooler();
        this.pc_builder.addDVDDrive();
        return this.pc_builder;
    }
}