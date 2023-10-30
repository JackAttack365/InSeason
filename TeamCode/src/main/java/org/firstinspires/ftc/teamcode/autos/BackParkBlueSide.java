package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BackParkBlue")
public class BackParkBlueSide extends Auto{

    public int firstDriveForward = 935;
    public int firstStrafeLeft = 2000;
    public int firstTurnLeft = 750;
    public int secondDriveForward = 1000;
    public int secondStrafeLeft = 1000;
    public int thirdDriveForward = 550;

    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(firstDriveForward);
        strafeLeft(firstStrafeLeft);
        spinCounterClockwise(firstTurnLeft);
        moveForward(secondDriveForward);
        //place pixel already stored on robot onto backdrop
        //add turning around so the robot is in the right position to place the pixel
        //add a pause so the robot has time to place the pixel before parking
        strafeLeft(secondStrafeLeft);
        moveForward(thirdDriveForward);
        //this leaves you in the parking area backstage

    }

}
