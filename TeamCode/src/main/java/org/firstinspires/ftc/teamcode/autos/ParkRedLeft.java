package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "ParkRedRight")

public class ParkRedLeft extends Auto {

    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare/4);
        strafeRight(strafeRightOneSquare*2);
    }
}

