package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BackParkBlue")
public class BackParkBlueSide extends Auto{

    private int firstDriveForward = 915;
    private int firstStrafeLeft = 2000;
    private int firstTurnLeft = 750;
    private int secondDriveForward = 1000;
    private int secondStrafeLeft = 1000;
    private int thirdDriveForward = 550;
    private int parkStrafe = 500;


    @Override
    public void runOpMode() throws InterruptedException {
        // INIT CODE
        initMotors();

        waitForStart();

        // Path
        moveForward(firstDriveForward);
        strafeLeft(firstStrafeLeft);
        spinCounterClockwise(firstTurnLeft);
        moveForward(secondDriveForward);
        score();
        //add turning around so the robot is in the right position to place the pixel
        //add a pause so the robot has time to place the pixel before parking
        strafeLeft(secondStrafeLeft);
        moveForward(thirdDriveForward);
        //this leaves you in the parking area backstage
        strafeRight(parkStrafe);
    }

}
