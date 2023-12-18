package org.firstinspires.ftc.teamcode.autos;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

//@Autonomous(name="SpikeParkRed")
public class SpikeparkRedside extends Auto{

    public int forward = 1500;
    public int sRightLeft = 200;
    public int sLeftright2 = 1000;
    public int side = 200;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
        // TODO: Add movement times. Uncomment
//        moveForward();
        moveForward(forward);
        strafeLeft(sRightLeft);
        score();
        strafeRight(sLeftright2);
        spinClockwise(side);
        score();

        //TODO: park

    }

}

