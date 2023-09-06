package org.firstinspires.ftc.teamcode.subsystem;

import org.firstinspires.ftc.teamcode.Config;

public abstract class SubSystem {
    protected final Config config;

    public SubSystem(Config config) {
        this.config = config;
    }
    public abstract void init();
    public abstract void update();
    public Config getConfig() {
        return config;
    }
}
