package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class Claw extends SubSystem {

    private Servo clawServo;
    double currPosition = 1;

    public Claw(Config config) {
        super(config);
    }

    @Override
    public void init() {
        clawServo = config.hardwareMap.get(Servo.class, Config.ARM_CLAW);
    }

    @Override
    public void update() {
        // todo: tune position values
        if (config.gamePad2.a) {
            clawServo.setPosition(1);
            currPosition = 1;
        }
        if (config.gamePad2.b) {
            clawServo.setPosition(0.5);
            currPosition = 0.5;
        }
        clawServo.setPosition(currPosition);
    }
}