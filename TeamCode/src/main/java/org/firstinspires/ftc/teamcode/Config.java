package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Config {
    public Telemetry telemetry;
    public HardwareMap hardwareMap;
    public Gamepad gamePad1;
    public Gamepad gamePad2;

    // Stores the hardwareMap names as constants
    // Drive system
    public static final String RIGHT_FRONT_DRIVE = "rightFrontDrive";
    public static final String RIGHT_BACK_DRIVE = "rightBackDrive";
    public static final String LEFT_FRONT_DRIVE = "leftFrontDrive";
    public static final String LEFT_BACK_DRIVE = "leftBackDrive";
    public static final String INTAKE_MOTOR = "intakeMotor";
   public static final  String LOW_ARM_MOTOR = "lowerArmMotor";
    public static final String UP_ARM_MOTOR = "upperArmMotor";
    private ElapsedTime runtime = new ElapsedTime();

    // Constructor
    public Config(Telemetry tlm, HardwareMap hwm, Gamepad gmp1, Gamepad gmp2) {
        this.telemetry = tlm;
        this.hardwareMap = hwm;
        this.gamePad1 = gmp1;
        this.gamePad2 = gmp2;
    }

    // Do Not Change
    void updateTelemetry() {
        telemetry.addData("Status", "Run Time: " + runtime.toString());

        telemetry.addData("G1: bumper", "%b %b", gamePad1.left_bumper, gamePad1.right_bumper);
        telemetry.addData("G1: trigger", "%4.2f, %4.2f", gamePad1.left_trigger, gamePad1.right_trigger);
    }
}
