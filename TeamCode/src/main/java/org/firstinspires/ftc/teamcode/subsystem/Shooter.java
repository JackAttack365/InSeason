package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

// This subsystem is for the entire shooter mechanism including the turntable
public class Shooter extends SubSystem {
    private DcMotor turntable;
    private DcMotor trigger;
    private DcMotor flywheel;
    private double turnTableWise;

    private double turnTableClockWise;
    private double triggerOn;
    private double flywheelOn;

    public Shooter(Config config) {
        super(config);
    }

    @Override
    public void init() {
        turntable = config.hardwareMap.get(DcMotor.class, Config.TURN_TABLE);
        trigger = config.hardwareMap.get(DcMotor.class, Config.TRIGGER_MOTOR);
        flywheel = config.hardwareMap.get(DcMotor.class, Config.FLYWHEEL_MOTOR);
        triggerOn = 0.5;
        flywheelOn = 0.7;
        turnTableWise = 0.63;
        turnTableClockWise = 0.23;



    }


    public void update() {
        if(config.gamePad1.x) {
            trigger.setPower(triggerOn);
            flywheel.setPower(flywheelOn);
            turntable.setPower(turnTableWise);
        }
        else
        {
            trigger.setPower(0);
            flywheel.setPower(0);
            turntable.setPower(turnTableClockWise);
        }
        //test
    }
}
