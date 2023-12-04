package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class AirplaneLauncher extends SubSystem {

    public AirplaneLauncher(Config config) {
        super(config);
    }
    public AirplaneLauncher(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    private Servo airplaneServo;

    @Override
    public void init() {

        airplaneServo = config.hardwareMap.get(Servo.class, Config.PLANE_LAUNCHER);
    }

    @Override
    public void update() {
        // Releases the launcher when Start-B controller's B button is pressed
        // todo: tune position values
        if (isOneController) {

            if (config.gamePad1.b) {
                airplaneServo.setPosition(0.13);
            }

        } else {
            if (config.gamePad2.b) {
                airplaneServo.setPosition(0.13);
            }
        }
    }
}

