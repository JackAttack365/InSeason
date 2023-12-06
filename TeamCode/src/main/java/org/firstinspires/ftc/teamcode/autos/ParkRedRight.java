package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "ParkRedRight")

public class ParkRedRight extends Auto {
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(100);
        strafeRight(2200);
    }
}

