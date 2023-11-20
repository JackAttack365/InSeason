package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BackParkBlue")
public class BackParkBlueSide extends Auto{

    private int firstDriveForward = 905;
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
        spinCounterClockwise(secondTurnLeft);
        score();
        //add turning around so the robot is in the right position to place the pixel
        //add a pause so the robot has time to place the pixel before parking
        strafeRight(thirdDriveForward);
        moveBackward(firstDriveBackward);
        //this leaves you in the parking area backstage
    }

    private void waitForStart() {
    }

}
