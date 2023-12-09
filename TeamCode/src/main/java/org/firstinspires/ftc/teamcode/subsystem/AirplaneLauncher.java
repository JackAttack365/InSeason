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
    private Servo planeClamp;

    @Override
    public void init() {

        airplaneServo = config.hardwareMap.get(Servo.class, Config.PLANE_LAUNCHER);
        planeClamp = config.hardwareMap.get(Servo.class, Config.PLANE_CLAMP);

        airplaneServo.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void update() {
        // Releases the launcher when Start-B controller's B button is pressed
        // todo: tune position values
        if (isOneController) {

            if (config.gamePad1.b) {
//                planeClamp.setPosition(0.1);
//                int i = 0;
//                while (i < 100000) {
//                    i++;
//                }
                airplaneServo.setPosition(2);

            }

        } else {
            if (config.gamePad2.b) {
                //planeClamp.setPosition(0.1);
//                int i = 0;
//                while (i < 10000000) {
//                    i++;
//                }
                airplaneServo.setPosition(2);
            }
        }
    }
}

