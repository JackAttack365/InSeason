package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystem.Arm;
import org.firstinspires.ftc.teamcode.subsystem.Claw;
import org.firstinspires.ftc.teamcode.subsystem.Drive;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.SubSystem;

import java.util.LinkedList;
import java.util.List;

public class ManualRobot {
    // Config class to all hardware controls
    Config config;
    List<SubSystem> subSystems = new LinkedList<>();

    // Constructor
    public ManualRobot(Config cfg) {
        config = cfg;
        // Register the subsystem. System will not work if it's not registered
        subSystems.add(new Drive(config));
        subSystems.add(new Arm(config));
        subSystems.add(new Claw(config));
        subSystems.add(new Intake(config));
    }

    // Initialize each subsystem
    public void init() {
        for (SubSystem sub : subSystems) {
            sub.init();
        }
    }

    // Update each subsystem
    public void update() {
        for (SubSystem sub : subSystems) {
            sub.update();
        }
    }


}
