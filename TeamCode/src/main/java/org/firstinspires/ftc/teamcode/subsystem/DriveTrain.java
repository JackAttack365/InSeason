package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

import java.util.List;
import java.util.ArrayList;

// This code is based on the GM0 code for a mecanum teleop found here: https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
public class DriveTrain extends SubSystem {
    DcMotor driveMotors[] = new DcMotors[4];

    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;

    public DriveTrain(Config cfg) {
        super(cfg);
    }

    public DriveTrain(Config cfg, boolean isOneController) {
        super(cfg, isOneController);
    }

    public void init() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        leftFrontDrive = config.hardwareMap.get(DcMotor.class, Config.LEFT_FRONT_DRIVE);
        rightFrontDrive = config.hardwareMap.get(DcMotor.class, Config.RIGHT_FRONT_DRIVE);
        leftBackDrive = config.hardwareMap.get(DcMotor.class, Config.LEFT_BACK_DRIVE);
        rightBackDrive = config.hardwareMap.get(DcMotor.class, Config.RIGHT_BACK_DRIVE);

        driveMotors[0] = (leftFrontDrive);
        driveMotors[1] = (rightFrontDrive);
        driveMotors[2] = (leftBackDrive);
        driveMotors[3] = (rightBackDrive);

        // Most robots need the motors on one side to be reversed to drive forward.
        // When you first test your robot, push the left joystick forward
        // and flip the direction ( FORWARD <-> REVERSE ) of any wheel that runs backwards
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE); // DO NOT CHANGE
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE); // DO NOT CHANGE
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD); // DO NOT CHANGE
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD); // DO NOT CHANGE
    }

    public void update() {

        // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
        double axial = -config.gamePad1.left_stick_y;  // Note: pushing stick forward gives negative value
        double lateral = config.gamePad1.left_stick_x * 1.1; // 1.1 fixes strafing issues
        // MUST BE INVERTED!
        double yaw = -config.gamePad1.right_stick_x;
        // Take the average of the 2 triggers
        double speed = 1 - (config.gamePad1.right_trigger + config.gamePad1.left_trigger) / 2;

        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        double leftFrontPower = (axial + lateral - yaw) * speed; // DO NOT CHANGE
        double rightFrontPower = (axial - lateral + yaw) * speed; // DO NOT CHANGE
        double leftBackPower = (axial - lateral - yaw) * speed; // DO NOT CHANGE
        double rightBackPower = (axial + lateral + yaw) * speed; // DO NOT CHANGE

        // Normalize the values so no wheel power exceeds 100%
        // This ensures that the robot maintains the desired motion.
        double max;
        max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));

        if (max > 1.0) {
            leftFrontPower /= max;
            rightFrontPower /= max;
            leftBackPower /= max;
            rightBackPower /= max;
        }

        // Send calculated power to wheels`
        leftFrontDrive.setPower(leftFrontPower);
        rightFrontDrive.setPower(rightFrontPower);
        leftBackDrive.setPower(leftBackPower);
        rightBackDrive.setPower(rightBackPower);

        // Show the elapsed game time and wheel power.
        config.telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
        config.telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
        config.telemetry.addData("Right Stick x Position", "%4.2f", yaw);
    }

    public void forwards(float distance, int speed) {
        final double DISTANCE_CONSTANT=2;
        final double DRIVE_POWER=speed;
        final int SLEEP_INTERVAL=10;

        int targetPosition=(int)DISTANCE_CONSTANT*distance;

        for(DcMotor motor : motors) {
            // Stop and reset the motor counter
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            // Set the target position by converting the distance into motor position values
            motor.setTargetPosition(targetPosition);       
            // Set the motor into the mode that uses the encoder to keep track of the position
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                 
        }

        // Sleep a bit to make sure the motor report as "busy"
        sleep(SLEEP_INTERVAL);

        // Loop as long as either motor reports as busy
        boolean isBusy=false;
        do {
            config.telemetry.addData("leftFrontDrive", leftFrontDrive.getCurrentPosition());
            config.telemetry.addData("rightFrontDrive", rightFrontDrive.getCurrentPosition());
            config.telemetry.addData("leftBackDrive", leftBackDrive.getCurrentPosition());
            config.telemetry.addData("rightBackDrive", rightBackDrive.getCurrentPosition());

            sleep(SLEEP_INTERVAL);
            isBusy=false;
            for(DcMotor motor : motors) {
                if(motor.isBusy())isBusy=true;
            }
        } while(isBusy);

        for(DcMotor motor : motors) {
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }  

    }

    public void backwards(float distance, int speed) {
        final double DISTANCE_CONSTANT=2;
        final double DRIVE_POWER=speed;
        final int SLEEP_INTERVAL=10;

        int targetPosition=(int)DISTANCE_CONSTANT*-distance;

        for(DcMotor motor : motors) {
            // Stop and reset the motor counter
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            // Set the target position by converting the distance into motor position values
            motor.setTargetPosition(targetPosition);       
            // Set the motor into the mode that uses the encoder to keep track of the position
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                 
        }

        // Sleep a bit to make sure the motor report as "busy"
        sleep(SLEEP_INTERVAL);
        
        // Loop as long as either motor reports as busy
        boolean isBusy=false;
        do {
            config.telemetry.addData("leftFrontDrive", leftFrontDrive.getCurrentPosition());
            config.telemetry.addData("rightFrontDrive", rightFrontDrive.getCurrentPosition());
            config.telemetry.addData("leftBackDrive", leftBackDrive.getCurrentPosition());
            config.telemetry.addData("rightBackDrive", rightBackDrive.getCurrentPosition());

            sleep(SLEEP_INTERVAL);
            isBusy=false;
            for(DcMotor motor : motors) {
                if(motor.isBusy())isBusy=true;
            }
        } while(isBusy);

        for(DcMotor motor : motors) {
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }  

    }

    public void turnLeft(float angle, int speed) {

    }
}