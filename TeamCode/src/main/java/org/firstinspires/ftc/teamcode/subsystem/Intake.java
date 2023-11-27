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
        if (isOneController) {
            // Toggles the intake when A is pressed on the Start A controller in One Controller Mode
//            if (config.gamePad1.a) {
//                if (isMotorRunning){
//                    intake.setPower(0);
//                    isMotorRunning = false;
//                } else {
//                    intake.setPower(1);
//                    isMotorRunning = true;
//                }
//            }
            if (config.gamePad2.a) {
                intake.setPower(1);
            } else {
                intake.setPower(0);
            }
        } else {
            // Toggles the intake when A is pressed on the Start B controller
//            if (config.gamePad2.a) {
//                if (isMotorRunning){
//                    intake.setPower(0);
//                    isMotorRunning = false;
//                } else {
//                    intake.setPower(1);
//                    isMotorRunning = true;
//                }
//            }
            if (config.gamePad2.a) {
                intake.setPower(1);
            } else {
                intake.setPower(0);
            }
        }
    }
    // Getter
    public boolean isIntakeMotorRunning() {
        return isMotorRunning;
    }

}
