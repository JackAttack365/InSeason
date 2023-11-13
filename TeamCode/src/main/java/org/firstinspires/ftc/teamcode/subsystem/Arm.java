package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class Arm extends SubSystem {

    private DcMotor lowerArmMotorRight;
    //private DcMotor lowerArmMotorLeft;
    private DcMotor upperArmMotor;
    // TODO: Tune Values
    private int lowerArmEncoderPositionScore = -1950;
    private long lowerArmEncoderPositionGrab = 0;
    public Arm (Config config) {
        super(config);
    }

    public Arm(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    @Override
    public void init() {
        lowerArmMotorRight = config.hardwareMap.get(DcMotor.class, Config.RIGHT_LOW_ARM_MOTOR);
        //lowerArmMotorLeft = config.hardwareMap.get(DcMotor.class, Config.LEFT_LOW_ARM_MOTOR);
        upperArmMotor = config.hardwareMap.get(DcMotor.class, Config.UP_ARM_MOTOR);
        lowerArmMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //lowerArmMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        upperArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void update() {


        // TODO: TUNE SPEED
        if(isOneController) {
            if (config.gamePad1.dpad_down){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(-1);

            } else if (config.gamePad1.dpad_up){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(1);
            } else {
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(0);
            }


            if (config.gamePad1.x) {
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                upperArmMotor.setPower(0.339);
            } else if (config.gamePad1.y) {
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                upperArmMotor.setPower(-0.339);
            } else {
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                upperArmMotor.setPower(0);
            }
        }
        else {
            double maxSpeed = 1;
            double speed = config.gamePad2.left_stick_y / 1.5;

            if (speed > maxSpeed) {
                speed = maxSpeed;
            }
            lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            lowerArmMotorRight.setPower(speed);

            if (config.gamePad2.x) {
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                upperArmMotor.setPower(0.339);
            } else if (config.gamePad2.y) {
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                upperArmMotor.setPower(-0.339);
            } else {
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                upperArmMotor.setPower(0);
            }
        }

        // Syncs both lower arm motors
        //lowerArmMotorLeft.setPower(lowerArmMotorRight.getPower());

        // Telemetry to help tune encoder values
        config.telemetry.addData("Lower Arm Motor Encoder Position", lowerArmMotorRight.getCurrentPosition());
        config.telemetry.addData("Upper Arm Motor Encoder Position", upperArmMotor.getCurrentPosition());

    }
}
