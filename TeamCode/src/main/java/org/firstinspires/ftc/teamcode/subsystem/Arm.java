package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class Arm extends SubSystem {

    private DcMotor lowerArmMotorRight;
    //private DcMotor lowerArmMotorLeft;
    private DcMotor upperArmMotor;
    // TODO: Tune Values
    private int lowerArmEncoderPositionScore = -2064;
    private int lowerArmEncoderPositionGrab = 0;
    //TODO: TUNE
    private int upperArmEncoderPositionScore = -700;
    private int upperArmEncoderPositionGrab = 0;
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
    }

    @Override
    public void update() {


        // TODO: TUNE SPEED
        // TODO: Add 1 controller mode for run to position
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

            double lowerArmSpeed = config.gamePad2.left_stick_y / 1.5;
            if (lowerArmSpeed > maxSpeed) {
                lowerArmSpeed = maxSpeed;
            }
            lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            lowerArmMotorRight.setPower(lowerArmSpeed);

            double upperArmSpeed = config.gamePad2.right_stick_y / 1.5;
            if (upperArmSpeed > maxSpeed) {
                upperArmSpeed = maxSpeed;
            }
            upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            upperArmMotor.setPower(upperArmSpeed);

            if (config.gamePad2.y) {
                // Positions the arm into scoring position
                lowerArmMotorRight.setTargetPosition(lowerArmEncoderPositionScore);
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lowerArmMotorRight.setPower(1);

                upperArmMotor.setTargetPosition(upperArmEncoderPositionScore);
                upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                upperArmMotor.setPower(1);
            } else if (config.gamePad2.x) {
                // Positions arm into grabbing position
                lowerArmMotorRight.setTargetPosition(lowerArmEncoderPositionGrab);
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lowerArmMotorRight.setPower(1);

                upperArmMotor.setTargetPosition(upperArmEncoderPositionGrab);
                upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                upperArmMotor.setPower(1);
            }


        }

        // Syncs both lower arm motors
        //lowerArmMotorLeft.setPower(lowerArmMotorRight.getPower());

        // Telemetry to help tune encoder values
        config.telemetry.addData("Lower Arm Motor Encoder Position", lowerArmMotorRight.getCurrentPosition());
        config.telemetry.addData("Upper Arm Motor Encoder Position", upperArmMotor.getCurrentPosition());

    }
}
