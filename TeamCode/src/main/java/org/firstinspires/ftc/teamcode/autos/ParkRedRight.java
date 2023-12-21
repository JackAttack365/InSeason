package org.firstinspires.ftc.teamcode.autos;

public class ParkRedRight extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare*2);
        spinClockwise(turn90);
        moveForward(forwardOneSquare*3);
        strafeRight(strafeRightOneSquare*2);
        moveForward(forwardOneSquare/2);
    }
}
