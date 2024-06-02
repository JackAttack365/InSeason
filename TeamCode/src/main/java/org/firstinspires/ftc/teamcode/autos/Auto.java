package org.firstinspires.ftc.teamcode.autos;

import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystem.sensor.IMU;
import org.firstinspires.ftc.teamcode.subsystem.sensor.DistanceSensor;
import org.firstinspires.ftc.teamcode.subsystem.sensor.Odometry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.LinkedList;
import java.util.List;

public class Auto {
    // Config class to all hardware controls
    Config config;
    // List of all registered subsystems
    List<SubSystem> subSystems = new LinkedList<>();

    public int alliance = null;

    // Constructor
    public Auto(Config cfg, boolean isOneController) {
        
    }

    // Initialize each subsystem
    public void init() {
        config = cfg;

        alliance = 0; // 0: Blue, 1: Red

        // Register the subsystem. System will not work if it's not registered
        subSystems.add(new DriveTrain(config, isOneController));
        subSystems.add(new IMU(config, isOneController));
        subSystems.add(new Odometry(config, isOneController));
        subSystems.add(new DistanceSensor(config, isOneController));

        for (SubSystem sub : subSystems) {
            sub.init();
        }
    }

    public void auto() {

    }
}
