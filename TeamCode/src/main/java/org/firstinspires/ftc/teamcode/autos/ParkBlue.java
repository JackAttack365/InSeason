package org.firstinspires.ftc.teamcode.autos;

public class ParkBlue extends Auto{

    public int firstDriveForward = 500;
    public int firstStrafeRight = 100;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        strafeRight(firstStrafeRight);
        moveForward(firstDriveForward);

        //This will leave the robot parked in the backstage area.
    }
}
