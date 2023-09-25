package org.firstinspires.ftc.teamcode.autos;

public class placeTwoParkRed extends Auto {
    public int firstStrafeLeft = 0;
    public int secondStrafeLeft = 0;
    public int firstMoveForward = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        strafeLeft(0);
        //place two pixels
        strafeLeft(0);
        moveForward(0); //this means park
    }
}
