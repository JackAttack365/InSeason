package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class Arm extends SubSystem {

    private DcMotor lowerArmMotorRight;
    //private DcMotor lowerArmMotorLeft;
    private DcMotor upperArmMotor;
    // TODO: Tune Values
    private long encoderPositionScore = 0;
    private long encoderPositionGrab = 0;
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
        //lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //lowerArmMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //lowerArmMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        upperArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void update() {


        // TODO: TUNE SPEED
        if(isOneController) {
            if (config.gamePad1.dpad_down){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(-1);

            }
            if (config.gamePad1.dpad_up){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(1);
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
            //lowerArmMotorLeft.setPower(speed);

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

        // Telemetry to help tune encoder values
        int lowerArmPositionRight = lowerArmMotorRight.getCurrentPosition();
        //int lowerArmPositionLeft = lowerArmMotorLeft.getCurrentPosition();
        int upperArmPosition = upperArmMotor.getCurrentPosition();
        config.telemetry.addData("Lower Arm Position Right", lowerArmPositionRight);
        //config.telemetry.addData("Lower Arm Position Left", lowerArmPositionLeft);
        config.telemetry.addData("Upper Arm Position", upperArmPosition);
    }
}
