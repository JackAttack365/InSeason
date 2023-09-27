package org.firstinspires.ftc.teamcode.autos;

public class PlaceOneBackThenSpikeParkRed extends Auto {
    public int firstStrafeLeft = 750;
    public int firstMoveBackward = 750;
    public int firstCounterClockwise = 1000;
    public int secondMoveBackward = 750;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        strafeLeft(firstStrafeLeft);
        //Place one pixel
        moveBackward(firstMoveBackward);
        spinCounterClockwise(firstCounterClockwise);
        //Place remaining pixel on spike with pixel/prop, need vision for this
        moveBackward(secondMoveBackward);
        //This will leave the robot in the backstage area
    }
}
