package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Config;

public class Odometry extends SubSystem {

    private DcMotorEx parallelLeft = null;
    private DcMotorEx parallelRight = null;
    private DcMotorEx perpendicular = null;

    private Pose2d startPose = null;

    public Odometry(Config cfg) {
        super(cfg);
    }

    public Odometry(Config cfg, boolean isOneController) {
        super(cfg, isOneController);
    }
    
    @Override
    public void init(Pose2d getStartPose) {
        parallelLeft = config.hardwareMap.get(DcMotorEx.class, "parallelLeft");
        parallelRight = config.hardwareMap.get(DcMotorEx.class, "parallelRight");
        perpendicular = config.hardwareMap.get(DcMotorEx.class, "perpendicular");


        this.startPose = getStartPose;
    }

    @Override
    public void update() {
        config.telemetry.addData("Heading %0.2f degrees", imu.getHeading());
    }

    public double getHeading() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }
}
