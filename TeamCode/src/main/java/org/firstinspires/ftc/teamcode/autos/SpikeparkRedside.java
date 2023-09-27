package org.firstinspires.ftc.teamcode.autos;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="SpikeParkRed")
public class SpikeparkRedside extends Auto{

    public int forward = 1500;
    public int sRightLeft = 450;
    public int sLeftright2 = 2000;
    public int side = 200;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
        // TODO: Add movement times. Uncomment
//        moveForward();
        moveForward(forward);
        strafeLeft(sRightLeft);
        // Place spike
        strafeRight(sLeftright2);
        spinClockwise(side);
        //place on board
        //park



    }

}

