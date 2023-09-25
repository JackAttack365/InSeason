package org.firstinspires.ftc.teamcode.autos;

public class SpikeparkBlueside extends Auto{
    public int forward = 0;
    public int sRight = 0;
    public int  sLeft = 0;
    public int Side = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
        // TODO: Add movement times. Uncomment
//        moveForward();
    moveForward(forward);
    strafeRight(sRight);
    // Place spike
        strafeLeft(sLeft);
        moveLeft(Side);
        //place on board
        //park



    }

}
