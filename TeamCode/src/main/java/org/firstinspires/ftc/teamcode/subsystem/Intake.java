package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

// This subsystem drags pixel from field onto the platform where the claw picks it up
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
            if (config.gamePad1.a) {
                intake.setPower(1);
            } else {
                intake.setPower(0);
            }
        } else {
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
