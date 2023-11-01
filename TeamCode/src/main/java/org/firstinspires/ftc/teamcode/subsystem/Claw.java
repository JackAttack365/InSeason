package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class Claw extends SubSystem {

    private Servo clawServo;
    double currPosition = 1;
    

    public static final double OPEN = 1;
    public static final double CLOSED = 0.63;

    public Claw(Config config) {
        super(config);
    }

    public Claw(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    @Override
    public void init() {
        clawServo = config.hardwareMap.get(Servo.class, Config.ARM_CLAW);
    }

    @Override
    public void update() {
        // todo: tune position values
        if (isOneController) {
            if (config.gamePad1.left_bumper) {
                clawServo.setPosition(Claw.OPEN);
                currPosition = Claw.OPEN;
            }
            if (config.gamePad1.right_bumper) {
                clawServo.setPosition(Claw.CLOSED);
                currPosition = Claw.CLOSED;
            }
        } else {
            if (config.gamePad2.left_bumper) {
                clawServo.setPosition(Claw.OPEN);
                currPosition = Claw.OPEN;
            }
            if (config.gamePad2.right_bumper) {
                clawServo.setPosition(Claw.CLOSED);
                currPosition = Claw.CLOSED;
            }
        }

        clawServo.setPosition(currPosition);
    }
}