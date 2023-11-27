package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class Claw extends SubSystem {

    private Servo clawServo;
    private Servo servoClaw;
    double currPosition = 0;


    public static final double OPEN = 0;
    public static final double CLOSED = -0.63;

    public Claw(Config config) {
        super(config);
    }

    public Claw(Config config, boolean isOneController) {
        super(config);
    }

    @Override
    public void init() {

        clawServo = config.hardwareMap.get(Servo.class, Config.ARM_CLAW);
        servoClaw = config.hardwareMap.get(Servo.class, Config.ARM_CLAW_2);
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
                currPosition = Claw.OPEN;
            }
            if (config.gamePad2.right_bumper) {
                currPosition = Claw.CLOSED;
            }
        }

        // Holds torque on game piece without moving
        clawServo.setPosition(currPosition);
        servoClaw.setPosition(currPosition);
    }


    }
