package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

// This subsystem is for the motor that moves balls onto the turntable
public class Intake extends SubSystem {

    private DcMotor intake;
    private boolean isMotorRunning = false;
    public Intake(Config config) {
        super(config);
    }

    public Intake(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    @Override
    public void init() {
        intake = config.hardwareMap.get(DcMotor.class, Config.INTAKE_MOTOR);
    }

    @Override
    public void update() {
        // TODO: ADD ONE CONTROLLER MODE
        if (config.gamePad2.a) {
            if (isMotorRunning){
                intake.setPower(0);
            } else {
                intake.setPower(1);
            }
        }
    }

}
