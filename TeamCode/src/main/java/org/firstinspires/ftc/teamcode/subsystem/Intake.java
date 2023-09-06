package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

// This subsystem is for the motor that moves balls onto the turntable
public class Intake extends SubSystem {

    private DcMotor intake;

    public Intake(Config config) {
        super(config);
    }

    @Override
    public void init() {
        intake = config.hardwareMap.get(DcMotor.class, Config.INTAKE_MOTOR);
    }

    @Override
    public void update() {
        if(config.gamePad1.y) {
            intake.setPower(1);
        } else {
            intake.setPower(0.5);
        }

    }
}
