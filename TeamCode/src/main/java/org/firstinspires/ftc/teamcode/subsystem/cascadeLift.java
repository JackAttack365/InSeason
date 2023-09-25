package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class cascadeLift extends SubSystem {

    private DcMotor lift;
    public cascadeLift(Config config) {
        super(config);
    }
    @Override
    public void init() {
        lift = config.hardwareMap.get(DcMotor.class, Config.LIFT);
    }
// if encoder position is less than or equal to 0, set power to 0.
// if encoder position is greater than or equal to max encoder ticks, set power to 0.
// if A is pressed on gamePad1, set power to -x
// if B is pressed on gamePad1, set power to x
    @Override
    public void update() {
        double x = 0.5;
        if (config.gamePad1.a) {
            lift.setPower(-0.5);
        }
        if (config.gamePad1.b) {
            lift.setPower(0.5);
        }

    }
}