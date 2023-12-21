package org.firstinspires.ftc.teamcode.autos;

public class BackdropParkRedBack extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare*2);
        spinCounterClockwise(turn90);
        moveForward(forwardOneSquare*3);
        strafeLeft(strafeLeftOneSquare);
        spinCounterClockwise(turn180);
        moveBackward(backwardOneSquare/4);
        //place pixels on backdrop
        strafeRight(strafeRightOneSquare);
        moveBackward(backwardOneSquare/2);
    }
}
