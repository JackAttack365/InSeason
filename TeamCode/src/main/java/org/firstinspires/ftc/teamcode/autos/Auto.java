package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public abstract class Auto extends LinearOpMode {
    protected DcMotor leftFrontDrive;
    protected DcMotor leftBackDrive;
    protected DcMotor rightFrontDrive;
    protected DcMotor rightBackDrive;
    protected DcMotor turnTable;
    protected DcMotor triggerMotor;
    protected DcMotor flywheelMotor;


    // Initialize. Similar to SubSystem.init();
    protected void initMotors() {
        leftFrontDrive = hardwareMap.get(DcMotor.class, Config.LEFT_FRONT_DRIVE);
        leftBackDrive = hardwareMap.get(DcMotor.class, Config.LEFT_BACK_DRIVE);
        rightFrontDrive = hardwareMap.get(DcMotor.class, Config.RIGHT_FRONT_DRIVE);
        rightBackDrive = hardwareMap.get(DcMotor.class, Config.RIGHT_BACK_DRIVE);
        // TODO: Reverse motors as needed.
    }
        public void moveBackward(long milliseconds) {
        leftFrontDrive.setPower(-1);
        leftBackDrive.setPower(-1);
        rightFrontDrive.setPower(-1);
        rightBackDrive.setPower(-1);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
        public void strafeRight(long milliseconds) {
        leftFrontDrive.setPower(1);
        leftBackDrive.setPower(-1);
        rightFrontDrive.setPower(-1);
        rightBackDrive.setPower(1);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
        public void strafeLeft(long milliseconds) {
        leftFrontDrive.setPower(-1);
        leftBackDrive.setPower(1);
        rightFrontDrive.setPower(1);
        rightBackDrive.setPower(-1);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
        public void moveForward(long milliseconds) {
        leftFrontDrive.setPower(1);
        leftBackDrive.setPower(1);
        rightFrontDrive.setPower(1);
        rightBackDrive.setPower(1);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void turnLeft(long milliseconds) {
        leftFrontDrive.setPower(1);
        leftBackDrive.setPower(1);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void turnRight(long milliseconds) {
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(1);
        rightBackDrive.setPower(1);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }


}
