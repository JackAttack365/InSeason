package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Config;

public class IMU extends SubSystem {

    private IMU imu = null;

    public IMU(Config cfg) {
        super(cfg);
    }

    public IMU(Config cfg, boolean isOneController) {
        super(cfg, isOneController);
    }
    
    @Override
    public void init() {
        imu = config.hardwareMap.get(IMU.class, "IMU");

        RevHubOrientationOnRobot RevOrientation = 
            new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.DOWN);
        
        imu.initialize(new IMU.Parameters(RevOrientation));
    }

    @Override
    public void update() {
        config.telemetry.addData("Heading %0.2f degrees", imu.getHeading());
    }

    public double getHeading() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }
}
