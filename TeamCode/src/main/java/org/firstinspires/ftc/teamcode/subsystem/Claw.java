package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class Claw extends SubSystem {

    // Claw Servo 1 is not working
    private Servo clawServo1;
    private Servo clawServo2;

    double currPositionClaw2;
    double currPositionClaw1;


    public static final double CLAW_2_CLOSED = 0.1;
    public static final double CLAW_1_CLOSED = 0.1;
    public static final double CLAW_1_OPEN = 0;
    public static final double CLAW_2_OPEN = 0;

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

//        // DEBUGGING
//        clawServo1.resetDeviceConfigurationForOpMode();
//        clawServo2.resetDeviceConfigurationForOpMode();

        //clawServo1.scaleRange(-1, 1);


        currPositionClaw2 = CLAW_2_CLOSED;
        currPositionClaw1 = CLAW_1_CLOSED;

    }

    @Override
    public void update() {
        // todo: make servos work (debugging)
        // todo: tune position values
        if (isOneController) {
            if (config.gamePad1.left_bumper) {
                currPositionClaw2 = CLAW_1_OPEN;
            }
            if (config.gamePad1.right_bumper) {
                currPositionClaw2 = CLAW_2_CLOSED;
            }
        } else {
            if (config.gamePad2.left_bumper) {
                config.telemetry.addData("left bumper pressed", 0);

                currPositionClaw2 = CLAW_2_OPEN;
                currPositionClaw1 = CLAW_1_OPEN;
            }
            if (config.gamePad2.right_bumper) {
                config.telemetry.addData("right bumper pressed", 0);
                currPositionClaw2 = CLAW_2_CLOSED;
                currPositionClaw1 = CLAW_1_CLOSED;
            }
        }

        // Holds torque on game piece without moving
        clawServo1.setPosition(currPositionClaw1);
        clawServo2.setPosition(currPositionClaw2);
        config.telemetry.addData("currPosition", currPositionClaw1);


    }


    }
