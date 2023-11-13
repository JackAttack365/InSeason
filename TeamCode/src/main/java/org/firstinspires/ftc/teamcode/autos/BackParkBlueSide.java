package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BackParkBlue")
public class BackParkBlueSide extends Auto{

    private int firstDriveForward = 915;
    private int firstTurnLeft = 725;
    private int secondDriveForward = 2000;
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
        spinCounterClockwise(firstTurnLeft);
        moveForward(secondDriveForward);
        //add turning around so the robot is in the right position to place the pixel (if needed)
        //score();
        strafeLeft(secondStrafeLeft);
        moveForward(thirdDriveForward);
        //this leaves you in the parking area backstage
        strafeRight(parkStrafe);
    }

}
