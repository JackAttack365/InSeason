package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

// Config stores everything any of our SubSystems need to function, stores GamePads, Telemetry, HardwareMap,
// and names of each motor
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
    // Scoring Mechanism
    public static final String INTAKE_MOTOR = "intakeMotor";
    public static final  String RIGHT_LOW_ARM_MOTOR = "lowerArmMotorRight";
    public static final  String LEFT_LOW_ARM_MOTOR = "lowerArmMotorLeft";
    public static final String UP_ARM_MOTOR = "upperArmMotor";
    public static final String ARM_CLAW_2 = "clawServo2";
    public static final String ARM_CLAW = "clawServo";
    // Plane Launcher (Not working)
    public static final String PLANE_LAUNCHER_SERVO = "launcherServo";

    // Current game runtime
    private ElapsedTime runtime = new ElapsedTime();

    // Constructor
    public Config(Telemetry tlm, HardwareMap hwm, Gamepad gmp1, Gamepad gmp2) {
        this.telemetry = tlm;
        this.hardwareMap = hwm;
        this.gamePad1 = gmp1;
        this.gamePad2 = gmp2;
    }

    // Telemetry is similar to logging. Appears in Driver Station
    void updateTelemetry() {
        telemetry.addData("Status", "Run Time: " + runtime.toString());

        telemetry.addData("G1: bumper", "%b %b", gamePad1.left_bumper, gamePad1.right_bumper);
        telemetry.addData("G1: trigger", "%4.2f, %4.2f", gamePad1.left_trigger, gamePad1.right_trigger);
    }
}
