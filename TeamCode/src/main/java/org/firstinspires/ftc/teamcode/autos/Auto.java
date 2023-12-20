package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

// Auto superclass. Has useful movement methods that can be used in all of our autos
public abstract class Auto extends LinearOpMode {
    protected DcMotor leftFrontDrive;
    protected DcMotor leftBackDrive;
    protected DcMotor rightFrontDrive;
    protected DcMotor rightBackDrive;
    protected DcMotor lowerArmMotorRight;
    protected DcMotor upperArmMotor;
    protected Servo airplaneLauncher;

    public double defaultMovementSpeed = 0.75;
    private final int lowerArmPositionScore = -2064;
    private final int upperArmPositionScore = -700;
    public int somepower = 1;

    // Initialize. Similar to SubSystem.init();
    protected void initMotors() {
        leftFrontDrive = hardwareMap.get(DcMotor.class, Config.LEFT_FRONT_DRIVE);
        leftBackDrive = hardwareMap.get(DcMotor.class, Config.LEFT_BACK_DRIVE);
        rightFrontDrive = hardwareMap.get(DcMotor.class, Config.RIGHT_FRONT_DRIVE);
        rightBackDrive = hardwareMap.get(DcMotor.class, Config.RIGHT_BACK_DRIVE);

        //arm motors
        lowerArmMotorRight = hardwareMap.get(DcMotor.class, Config.RIGHT_LOW_ARM_MOTOR);
        upperArmMotor = hardwareMap.get(DcMotor.class, Config.UP_ARM_MOTOR);

        airplaneLauncher = hardwareMap.get(Servo.class, Config.PLANE_LAUNCHER);

        // Most robots need the motors on one side to be reversed to drive forward.
        // When you first test your robot, push the left joystick forward
        // and flip the direction ( FORWARD <-> REVERSE ) of any wheel that runs backwards
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE); // DO NOT CHANGE
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE); // DO NOT CHANGE
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD); // DO NOT CHANGE
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD); // DO NOT CHANGE

        lowerArmMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        upperArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }
    public void moveBackward(long milliseconds, double speed) {
        leftFrontDrive.setPower(-speed);
        leftBackDrive.setPower(-speed);
        rightFrontDrive.setPower(-speed);
        rightBackDrive.setPower(-speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void strafeRight(long milliseconds, double speed) {
        leftFrontDrive.setPower(speed);
        leftBackDrive.setPower(-speed);
        rightFrontDrive.setPower(-speed);
        rightBackDrive.setPower(speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void strafeLeft(long milliseconds, double speed) {
        leftFrontDrive.setPower(-speed);
        leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(speed);
        rightBackDrive.setPower(-speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void moveForward(long milliseconds, double speed) {
        leftFrontDrive.setPower(speed);
        leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(speed);
        rightBackDrive.setPower(speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void spinCounterClockwise(long milliseconds, double speed) {
        leftFrontDrive.setPower(-speed);
        leftBackDrive.setPower(-speed);
        rightFrontDrive.setPower(speed);
        rightBackDrive.setPower(speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void spinClockwise(long milliseconds, double speed) {
        leftFrontDrive.setPower(speed);
        leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(-speed);
        rightBackDrive.setPower(-speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void moveBackward(long milliseconds) {
        leftFrontDrive.setPower(-defaultMovementSpeed);
        leftBackDrive.setPower(-defaultMovementSpeed);
        rightFrontDrive.setPower(-defaultMovementSpeed);
        rightBackDrive.setPower(-defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void strafeRight(long milliseconds) {
        leftFrontDrive.setPower(defaultMovementSpeed);
        leftBackDrive.setPower(-defaultMovementSpeed);
        rightFrontDrive.setPower(-defaultMovementSpeed);
        rightBackDrive.setPower(defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void strafeLeft(long milliseconds) {
        leftFrontDrive.setPower(-defaultMovementSpeed);
        leftBackDrive.setPower(defaultMovementSpeed);
        rightFrontDrive.setPower(defaultMovementSpeed);
        rightBackDrive.setPower(-defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void moveForward(long milliseconds) {
        leftFrontDrive.setPower(defaultMovementSpeed);
        leftBackDrive.setPower(defaultMovementSpeed);
        rightFrontDrive.setPower(defaultMovementSpeed);
        rightBackDrive.setPower(defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void spinCounterClockwise(long milliseconds) {
        leftFrontDrive.setPower(-defaultMovementSpeed);
        leftBackDrive.setPower(-defaultMovementSpeed);
        rightFrontDrive.setPower(defaultMovementSpeed);
        rightBackDrive.setPower(defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void spinClockwise(long milliseconds) {
        leftFrontDrive.setPower(defaultMovementSpeed);
        leftBackDrive.setPower(defaultMovementSpeed);
        rightFrontDrive.setPower(-defaultMovementSpeed);
        rightBackDrive.setPower(-defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void score()
    {
//        lowerArmMotorRight.setTargetPosition(lowerArmPositionScore);
//        lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        lowerArmMotorRight.setPower(somepower);
//
//        upperArmMotor.setTargetPosition(upperArmPositionScore);
//        upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        upperArmMotor.setPower(somepower);
    }

    public void setPlaneLauncherCurrPosition(double position) {
        airplaneLauncher.setPosition(position);
    }
}
