package org.firstinspires.ftc.teamcode.autos;

public class BackdropParkBlueLeft extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare/4);
        strafeLeft(strafeLeftOneSquare);
        moveForward(forwardOneSquare);
        spinClockwise(turn90);
        moveBackward(backwardOneSquare/4);
        //place pixels on backdrop
        strafeRight(strafeRightOneSquare);
        moveBackward(backwardOneSquare/2);
    }
}
