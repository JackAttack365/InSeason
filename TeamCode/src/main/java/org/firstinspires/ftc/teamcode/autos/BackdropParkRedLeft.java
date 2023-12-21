package org.firstinspires.ftc.teamcode.autos;

public class BackdropParkRedLeft extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare/4);
        strafeRight(strafeRightOneSquare);
        moveForward(forwardOneSquare);
        spinCounterClockwise(turn90);
        moveBackward(backwardOneSquare/4);
        //place pixels on backdrop
        strafeLeft(strafeRightOneSquare);
        moveBackward(backwardOneSquare/2);
    }
}
