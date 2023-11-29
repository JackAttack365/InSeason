package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class Claw extends SubSystem {

    private Servo clawServo1;
    private Servo clawServo2;
    double currPosition;


    public static final double CLOSED = 0;
    public static final double OPEN = 0.1;

    public Claw(Config config) {
        super(config);
    }

    public Claw(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    @Override
    public void init() {

        clawServo1 = config.hardwareMap.get(Servo.class, Config.CLAW_SERVO_1);
        clawServo2 = config.hardwareMap.get(Servo.class, Config.CLAW_SERVO_2);

        clawServo1.resetDeviceConfigurationForOpMode();
        clawServo2.resetDeviceConfigurationForOpMode();

        clawServo2.setDirection(Servo.Direction.FORWARD);
        clawServo1.setDirection(Servo.Direction.REVERSE);

        currPosition = Claw.CLOSED;

    }

    @Override
    public void update() {
        // todo: tune position values
        if (isOneController) {
            if (config.gamePad1.left_bumper) {
                currPosition = Claw.OPEN;
            }
            if (config.gamePad1.right_bumper) {
                currPosition = Claw.CLOSED;
            }
        } else {
            if (config.gamePad2.left_bumper) {
                config.telemetry.addData("left bumper pressed", 0);

                currPosition = Claw.OPEN;
            }
            if (config.gamePad2.right_bumper) {
                config.telemetry.addData("right bumper pressed", 0);

                currPosition = Claw.CLOSED;
            }
        }

        // Holds torque on game piece without moving
        clawServo1.setPosition(-currPosition);
        clawServo2.setPosition(currPosition);
        config.telemetry.addData("currPosition", currPosition);


    }


    }
