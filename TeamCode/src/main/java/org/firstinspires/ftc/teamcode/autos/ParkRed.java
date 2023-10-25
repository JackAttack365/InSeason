package org.firstinspires.ftc.teamcode.autos;

public class ParkRed extends Auto{

   public int firstDriveForward = 500;
   public int firstStrafeLeft = 100;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        strafeLeft(firstStrafeLeft);
        moveForward(firstDriveForward);
        //This will leave the robot parked in the backstage area.
    }
}
