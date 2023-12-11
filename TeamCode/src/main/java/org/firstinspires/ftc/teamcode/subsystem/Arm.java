package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class Arm extends SubSystem {

    private DcMotor lowerArmMotorRight;
    private DcMotor lowerArmMotorLeft;
    private DcMotor upperArmMotor;

    private int upperArmMotorTargetPos = 0;
    private int upperArmMotorPosIncrements = 50;
    // TODO: Tune Values
    private int lowerArmEncoderPositionScore = -2064;
    private int lowerArmEncoderPositionGrab = 0;
    //TODO: TUNE
    private int upperArmEncoderPositionScore = -700;
    private int upperArmEncoderPositionGrab = 0;
    private double upperArmPower = 0.3;
    public Arm (Config config) {
        super(config);
    }

    public Arm(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    @Override
    public void init() {
        lowerArmMotorRight = config.hardwareMap.get(DcMotor.class, Config.RIGHT_LOW_ARM_MOTOR);
        lowerArmMotorLeft = config.hardwareMap.get(DcMotor.class, Config.LEFT_LOW_ARM_MOTOR);
        upperArmMotor = config.hardwareMap.get(DcMotor.class, Config.UP_ARM_MOTOR);

        upperArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void update() {

        // TODO: test arm
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
                upperArmMotorTargetPos = upperArmMotor.getCurrentPosition()+10;

            } else if (config.gamePad1.y) {
                upperArmMotorTargetPos = upperArmMotor.getCurrentPosition()-10;
            }

        } else {

            double maxSpeed = 1;

            double lowerArmSpeed = config.gamePad2.left_stick_y / 1.5;
            if (lowerArmSpeed > maxSpeed) {
                lowerArmSpeed = maxSpeed;
            }
            lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            lowerArmMotorRight.setPower(lowerArmSpeed);


            if (config.gamePad2.dpad_up) {
                upperArmMotorTargetPos = upperArmMotor.getCurrentPosition()-upperArmMotorPosIncrements;

            } else if (config.gamePad2.dpad_down) {
                upperArmMotorTargetPos = upperArmMotor.getCurrentPosition()+upperArmMotorPosIncrements;
            }

        }



        // Syncs both lower arm motors
        lowerArmMotorLeft.setPower(lowerArmMotorRight.getPower());

        upperArmMotor.setTargetPosition(upperArmMotorTargetPos);
        upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        upperArmMotor.setPower(upperArmPower);

        // Telemetry to help tune encoder values
        //config.telemetry.addData("Lower Arm Motor Encoder Position", lowerArmMotorRight.getCurrentPosition());
    }
}
