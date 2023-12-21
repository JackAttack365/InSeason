package org.firstinspires.ftc.teamcode.autos;

public class ParkBlueRight extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare*2);
        spinCounterClockwise(turn90);
        moveForward(forwardOneSquare*3);
        strafeLeft(strafeLeftOneSquare*2);
        moveForward(forwardOneSquare/2);
    }
}
