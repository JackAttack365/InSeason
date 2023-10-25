package org.firstinspires.ftc.teamcode.subsystem;

import org.firstinspires.ftc.teamcode.Config;

public abstract class SubSystem {
    protected final Config config;
    protected final boolean isOneController;

    public SubSystem(Config config) {
        this.config = config;
        this.isOneController = false;
    }

    public SubSystem(Config config, boolean isOneController) {
        this.config = config;
        this.isOneController = isOneController;
    }
    public abstract void init();
    public abstract void update();
    public Config getConfig() {
        return config;
    }
}
