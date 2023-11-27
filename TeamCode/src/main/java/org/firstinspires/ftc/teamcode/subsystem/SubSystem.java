package org.firstinspires.ftc.teamcode.subsystem;

import org.firstinspires.ftc.teamcode.Config;

public abstract class SubSystem {
    // All subsystems have access to these variables
    protected final Config config;
    protected final boolean isOneController;

    // Constructors
    public SubSystem(Config config) {
        this.config = config;
        this.isOneController = false;
    }
    public SubSystem(Config config, boolean isOneController) {
        this.config = config;
        this.isOneController = isOneController;
    }


    // Methods to implement by each subsystem
    public abstract void init();
    public abstract void update();

    // Getters
    public Config getConfig() {
        return config;
    }
    public boolean isOneController() {
        return isOneController;
    }
}
