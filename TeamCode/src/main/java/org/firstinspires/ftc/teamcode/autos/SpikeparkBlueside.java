package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="SpikeParkBlue")
public class SpikeparkBlueside extends Auto{
    public int forward = 1500;
    public int sRightLeft = 200;
    public int sLeftright2 = 2000;
    public int side = 200;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
//        moveForward();
    moveForward(forward);
    strafeRight(sRightLeft);
    // Place spike
        strafeLeft(sLeftright2);
        spinCounterClockwise(side);
        //place on board
        //park



    }

}
