package org.firstinspires.ftc.teamcode.autos;

public class BackSpikeParkRed extends Auto{
    public int firstStrafeLeft = 500;
    public int firstMoveBackward = 750;
    public int firstCounterClockwise = 750;
    public int secondMoveBackward = 750;

    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
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
