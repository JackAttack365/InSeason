package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;
import org.firstinspires.ftc.teamcode.TeleOpManual;

public class Arm extends SubSystem {

    private DcMotor lowerArmMotorRight;
    private DcMotor lowerArmMotorLeft;
    private DcMotor upperArmMotor;

    private int upperArmMotorTargetPos = 0;
    private int lastUpperArmMotorTargetPos = 0;
    private int lastLowerArmLeftPos = 0;
    private int lastLowerArmRightPos = 0;
    private int upperArmMotorPosIncrements = 100;
    // TODO: Tune Values
    private int lowerArmLeftEncoderPositionScore = 2144;
    private int lowerArmLeftEncoderPositionGrab = 0;
    private int lowerArmLeftEncoderPositionHang = 0;
    private int lowerArmRightEncoderPositionScore = 2161;
    private int lowerArmRightEncoderPositionGrab = 0;
    private int lowerArmRightEncoderPositionHang = 0;
    //TODO: TUNE
    private int upperArmEncoderPositionScore = -1900;
    private int upperArmEncoderPositionGrab = 2398;
    private int upperArmEncoderPositionHang = 2820;
    private int upperArmMotorEndPos = 0;
    private double upperArmPower = 1;
    private double lowerArmPower = 1;

    private TeleOpManual teleOpManual;
    public Arm (Config config) {
        super(config);
    }

    public Arm(Config config, boolean isOneController) {
        super(config, isOneController);
        teleOpManual = new TeleOpManual();
    }

    @Override
    public void init() {
        lowerArmMotorRight = config.hardwareMap.get(DcMotor.class, Config.RIGHT_LOW_ARM_MOTOR);
        lowerArmMotorLeft = config.hardwareMap.get(DcMotor.class, Config.LEFT_LOW_ARM_MOTOR);
        upperArmMotor = config.hardwareMap.get(DcMotor.class, Config.UP_ARM_MOTOR);

        upperArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lowerArmMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lowerArmMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void update() {

        // TODO: test arm
        // TODO: TUNE SPEED
        if(isOneController) {
            if (config.gamePad1.x){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(-1);
            } else if (config.gamePad1.y){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(1);

            } else {
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(0);

            }

            if (config.gamePad1.dpad_up) {
                upperArmMotorTargetPos = upperArmMotor.getCurrentPosition()+upperArmMotorPosIncrements;

            } else if (config.gamePad1.dpad_down) {
                upperArmMotorTargetPos = upperArmMotor.getCurrentPosition()-upperArmMotorPosIncrements;
            }

        } else {

            double maxSpeed = 1;
            double speed = 1 - ((config.gamePad2.right_trigger + config.gamePad2.left_trigger) / 2);

            double lowerArmSpeed = (config.gamePad2.left_stick_y / 1.5) * speed;
            if (lowerArmSpeed > maxSpeed) {
                lowerArmSpeed = maxSpeed;
            }
            lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            lowerArmMotorRight.setPower(lowerArmSpeed);


            if (config.gamePad2.y) {
                upperArmMotorTargetPos = upperArmMotor.getCurrentPosition()-upperArmMotorPosIncrements;

            } else if (config.gamePad2.x) {
                if (!(upperArmMotor.getCurrentPosition() > upperArmMotorEndPos)) {
                    upperArmMotorTargetPos = upperArmMotor.getCurrentPosition() + upperArmMotorPosIncrements;
                }
            }

            if (config.gamePad2.dpad_up) {
                storeCurrentArmPosition();
                // Moves the arm to scoring position
                runLowerArmToPosition(lowerArmLeftEncoderPositionScore, lowerArmRightEncoderPositionScore);
                teleOpManual.aSleep(10000);
                upperArmMotorTargetPos = upperArmEncoderPositionScore;
            } else if (config.gamePad2.dpad_down) {
                storeCurrentArmPosition();
                // Moves the arm to grabbing position
                runLowerArmToPosition(lowerArmLeftEncoderPositionGrab, lowerArmRightEncoderPositionGrab);
                teleOpManual.aSleep(1000);
                upperArmMotorTargetPos = upperArmEncoderPositionGrab;
            } else if (config.gamePad2.dpad_left) {
                storeCurrentArmPosition();
                // Moves the arm to hanging position
                upperArmMotorTargetPos = upperArmEncoderPositionHang;
                teleOpManual.aSleep(1000);
                runLowerArmToPosition(lowerArmLeftEncoderPositionHang, lowerArmRightEncoderPositionHang);
            }

            if (config.gamePad2.back) {
                upperArmMotorTargetPos = lastUpperArmMotorTargetPos;
                runLowerArmToPosition(lastLowerArmLeftPos, lastLowerArmRightPos);
            }

        }



        // Syncs both lower arm motors
        lowerArmMotorLeft.setPower(lowerArmMotorRight.getPower());

        upperArmMotor.setTargetPosition(upperArmMotorTargetPos);
        upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        upperArmMotor.setPower(upperArmPower);

        // Telemetry to help tune encoder values
        config.telemetry.addData("Upper Arm Motor Encoder Position", upperArmMotor.getCurrentPosition());
        config.telemetry.addData("Lower Arm Motor Left Encoder Position", lowerArmMotorLeft.getCurrentPosition());
        config.telemetry.addData("Lower Arm Motor Right Encoder Position", lowerArmMotorRight.getCurrentPosition());
    }

    private void runLowerArmToPosition(int leftTarget, int rightTarget) {
        lowerArmMotorLeft.setTargetPosition(leftTarget);
        lowerArmMotorRight.setTargetPosition(rightTarget);

        lowerArmMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        lowerArmMotorLeft.setPower(lowerArmPower);
        lowerArmMotorRight.setPower(-lowerArmPower);
    }

    private void storeCurrentArmPosition() {
        lastLowerArmLeftPos = lowerArmMotorLeft.getCurrentPosition();
        lastLowerArmRightPos = lowerArmMotorRight.getCurrentPosition();
        lastUpperArmMotorTargetPos = upperArmMotorTargetPos;
    }
}
