package org.firstinspires.ftc.teamcode.autos;

public class BackdropParkRedRight extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare*2);
        spinClockwise(turn90);
        moveForward(forwardOneSquare*3);
        strafeRight(strafeRightOneSquare);
        spinClockwise(turn180);
        moveBackward(backwardOneSquare/4);
        //place pixels on backdrop
        strafeLeft(strafeLeftOneSquare);
        moveBackward(backwardOneSquare/2);
    }
}
