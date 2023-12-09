package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BackParkBlue")
public class ParkBlueSide extends Auto{
    // TODO: tune values
    private int firstDriveForward = 1810;
    private int firstTurnLeft = 750;
    private int secondTurnLeft = 1000;
    private int secondDriveForward = 2050;
    private int thirdDriveForward = 550;
    private int firstDriveBackward = 200;

    @Override
    public void runOpMode() throws InterruptedException {
        // INIT CODE
        initMotors();

        waitForStart();

        // Path
        moveForward(firstDriveForward);
        spinCounterClockwise(firstTurnLeft);
        moveForward(secondDriveForward);
        //add a pause so the robot has time to place the pixel before parking
        strafeRight(thirdDriveForward);
        //this leaves you in the parking area backstage
    }



}
